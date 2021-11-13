package com.halo.test;

import cn.hutool.core.io.FileUtil;
import io.jsonwebtoken.*;
import org.junit.Test;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Halo
 * @create 2021/11/13 下午 02:34
 * @description JWT 测试
 */
public class JwtTest {
    // 生成 JWT, 不使用签名
    @Test
    public void test1() {
        // 添加构成 JWT 的参数, JWT 头
        Map<String, Object> headMap = new HashMap();
        // 不使用签名算法
        headMap.put("alg", "none");
        // 令牌类型
        headMap.put("typ", "JWT");

        // JWT 有效载荷
        Map body = new HashMap();
        body.put("userId", "1");
        body.put("username", "halo");
        body.put("role", "admin");

        // 生成 JWT 令牌
        String jwt = Jwts.builder()
                .setHeader(headMap)
                .setClaims(body)
                // 设置 JWT 唯一标识
                .setId("jwt001")
                .compact();

        System.out.println(jwt);

        // 解析 JWT
        Jwt result = Jwts.parser().parse(jwt);
        Object jwtBody = result.getBody();
        Header header = result.getHeader();

        System.out.println(result);
        System.out.println(jwtBody);
        System.out.println(header);
    }

    // 生成 JWT 时使用签名算法生成签名部分 —— 基于 HS256 签名算法
    @Test
    public void test2() {
        // 密钥
        String salt = "salt-password";

        Map<String, Object> headMap = new HashMap();
        // 使用 HS256 签名算法
        headMap.put("alg", SignatureAlgorithm.HS256.getValue());
        headMap.put("typ", "JWT");

        Map body = new HashMap();
        body.put("userId", "1");
        body.put("username", "halo");
        body.put("role", "admin");

        String jwt = Jwts.builder()
                .setHeader(headMap)
                .setClaims(body)
                .setId("jwt001")
                // 设置密钥
                .signWith(SignatureAlgorithm.HS256, salt)
                .compact();

        System.out.println(jwt);

        // 解析 JWT
        Jwt result = Jwts.parser().setSigningKey(salt).parse(jwt);
        Object jwtBody = result.getBody();
        Header header = result.getHeader();

        System.out.println(result);
        System.out.println(jwtBody);
        System.out.println(header);
    }


    // 生成自己的 秘钥/公钥 对
    @Test
    public void test3() throws Exception {
        // 自定义 随机密码, 请修改这里
        String password = "halo-password";

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        SecureRandom secureRandom = new SecureRandom(password.getBytes());
        keyPairGenerator.initialize(1024, secureRandom);
        KeyPair keyPair = keyPairGenerator.genKeyPair();

        byte[] publicKeyBytes = keyPair.getPublic().getEncoded();
        byte[] privateKeyBytes = keyPair.getPrivate().getEncoded();

        FileUtil.writeBytes(publicKeyBytes, "d:\\pub.key");
        FileUtil.writeBytes(privateKeyBytes, "d:\\pri.key");
    }

    // 获取私钥
    public PrivateKey getPriKey() throws Exception {
        InputStream resourceAsStream = FileUtil.getInputStream("d:\\pri.key");
        DataInputStream dis = new DataInputStream(resourceAsStream);
        byte[] keyBytes = new byte[resourceAsStream.available()];
        dis.readFully(keyBytes);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }

    // 获取公钥
    public PublicKey getPubKey() throws Exception {
        InputStream resourceAsStream =FileUtil.getInputStream("d:\\pub.key");
        DataInputStream dis = new DataInputStream(resourceAsStream);
        byte[] keyBytes = new byte[resourceAsStream.available()];
        dis.readFully(keyBytes);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePublic(spec);
    }

    // 生成 JWT 时使用签名算法生成签名部分 —— 基于 RS256 签名算法
    @Test
    public void test4() throws Exception {
        Map<String, Object> headMap = new HashMap();
        // 使用 RS256 签名算法
        headMap.put("alg", SignatureAlgorithm.RS256.getValue());
        headMap.put("typ", "JWT");

        Map body = new HashMap();
        body.put("userId", "1");
        body.put("username", "halo");
        body.put("role", "admin");

        String jwt = Jwts.builder()
                .setHeader(headMap)
                .setClaims(body)
                .setId("jwt001")
                // 使用私钥加密
                .signWith(SignatureAlgorithm.RS256, getPriKey())
                .compact();
        System.out.println(jwt);

        // 解析 JWT, 使用公钥解密
        Jwt result = Jwts.parser().setSigningKey(getPubKey()).parse(jwt);
        Object jwtBody = result.getBody();
        Header header = result.getHeader();

        System.out.println(result);
        System.out.println(jwtBody);
        System.out.println(header);
    }
}