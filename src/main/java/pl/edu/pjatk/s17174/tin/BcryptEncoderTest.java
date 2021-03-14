package pl.edu.pjatk.s17174.tin;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptEncoderTest {

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String enc = bCryptPasswordEncoder.encode("Jan1234$");
        System.out.println(enc);
    }
}
