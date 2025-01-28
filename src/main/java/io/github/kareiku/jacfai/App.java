package io.github.kareiku.jacfai;

import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Board> boards = List.of(new Board());

        System.out.println(boards);

        boards = boards.get(0).expansion();

        System.out.println(boards);
    }
}
