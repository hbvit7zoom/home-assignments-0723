package builder;

import lombok.Builder;

@Builder
public class A1 {

    private String s;
    private String s1;
    private String s2;

    public static void main(String[] args) {
        A1 a = A1.builder()
                .s2("Поле s2")
                .build();
    }
}
