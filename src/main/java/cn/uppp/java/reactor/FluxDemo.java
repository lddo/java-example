package cn.uppp.java.reactor;

import reactor.core.publisher.Flux;

/**
 * @author ldd
 * @date 2019/11/26
 */
public class FluxDemo {
    public static void main(String[] args) {
        Flux.just("a", "b", "c").subscribe(System.out::println);
    }
}
