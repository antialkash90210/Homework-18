package com.company;

import java.util.Random;
import java.util.Scanner;

public class Tic_Tac_Toe {

    public static void main(String[] args) {

        int fieldSize = 3;//кол-во клеток по i и j
        char field[][] = new char[fieldSize][fieldSize];//поле

        final char EMPTY_CELL = '.';//не открытая ячейка
        final char USER_CELL = 'X';//крестик - ход игрока
        final char COMP_CELL = 'O';//нолик - ход компа

        int iCell = 0, jCell = 0;//клетки для заполнения по вертикали и горизонтали

        boolean isPlay = true;//процесс игрового цикла
        boolean isCorrectInput = true;//корректный ввод

        final int USER_STEP = 1;//ход игрока-первый
        final int COMP_STEP = 2;//ход компа-второй

        int step = USER_STEP;//ход

        //вывод при окончании игры
        final String USER_WIN = "Победил игрок(МОЛОДЕЦ)";
        final String COMP_WIN = "Победил компьютер(ПОВЕЗЕТ В ДРУГОЙ РАЗ)";

        //обнуляем ячейки поля
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                field[i][j] = EMPTY_CELL;
            }
        }

        // TODO: 08.07.2021 game loop
        System.out.println("Добро пожаловать в игру крестики-нолики!!!!");
        while (isPlay == true) {
            //отступ
            for (int k = 0; k < 1; k++) {
                System.out.println();
            }

            //вывод поля на экран
            for (int i = 0; i < fieldSize; i++) {
                for (int j = 0; j < fieldSize; j++) {
                    System.out.printf("%-3c", field[i][j]);
                }
                System.out.println();
            }
            System.out.println();

            Random random = new Random();

            // TODO: 08.07.2021 player turn cycle 
            switch (step) {
                case USER_STEP:
                    System.out.println("Ход игрока");

                    do {
                        isCorrectInput = true;
                        Scanner input = new Scanner(System.in);

                        try {
                            System.out.print("Введите i: ");
                            iCell = input.nextInt();

                            System.out.print("Введите j: ");
                            jCell = input.nextInt();

                        } catch (Exception e) {
                            isCorrectInput = false;
                            continue;
                        }

                        //проверка границ
                        if (iCell < 0 || iCell > fieldSize - 1 || jCell < 0 || jCell > fieldSize - 1) {
                            isCorrectInput = false;//если не входит в границы поля,продолжать вводить
                            continue;
                        }

                        if (field[iCell][jCell] == USER_CELL || field[iCell][jCell] == COMP_CELL) {
                            isCorrectInput = false;//если попадает в уже использованную ячейку,продолжать вводить
                            continue;
                        }

                        for (int i = 0; i < 1; i++) {
                            for (int j = 0; j < 1; j++) {
                                field[iCell][jCell] = USER_CELL;//шаг игрока
                            }
                        }
                    }

                    while (isCorrectInput == false);

                    //вывод поля
                    for (int i = 0; i < fieldSize; i++) {
                        for (int j = 0; j < fieldSize; j++) {
                            System.out.printf("%-3c", field[i][j]);
                        }
                        System.out.println();
                    }

                case COMP_STEP:
                    System.out.println("Ход компьютера");
                    System.out.println("Для продолжения нажмите <Enter>");
                    Scanner input = new Scanner(System.in);
                    input.nextLine();

                    for (int i = 0; i < 1; i++) {
                        for (int j = 0; j < 1; j++) {
                            do {
                                iCell = random.nextInt(fieldSize);
                                jCell = random.nextInt(fieldSize);

                            }
                            while (field[iCell][jCell] != EMPTY_CELL);

                            field[iCell][jCell] = COMP_CELL;//шаг компа
                        }
                    }
            }

            // TODO: 08.07.2021 game logic of a player's or computer's victory

            //условия победы игрока
            if (field[0][0] == USER_CELL && field[0][1] == USER_CELL && field[0][2] == USER_CELL) {
                System.out.println(USER_WIN);
                isPlay=false;
            }

            if (field[1][0] == USER_CELL && field[1][1] == USER_CELL && field[1][2] == USER_CELL) {
                System.out.println(USER_WIN);
                isPlay=false;
            }
            if (field[2][0] == USER_CELL && field[2][1] == USER_CELL && field[2][2] == USER_CELL) {
                System.out.println(USER_WIN);
                isPlay=false;
            }
            if (field[0][0] == USER_CELL && field[1][0] == USER_CELL && field[2][0] == USER_CELL) {
                System.out.println(USER_WIN);
                isPlay=false;
            }

            if (field[0][1] == USER_CELL && field[1][1] == USER_CELL && field[2][1] == USER_CELL) {
                System.out.println(USER_WIN);
                isPlay=false;
            }
            if (field[0][2] == USER_CELL && field[1][2] == USER_CELL && field[2][2] == USER_CELL) {
                System.out.println(USER_WIN);
                isPlay=false;
            }
            if (field[2][0] == USER_CELL && field[1][1] == USER_CELL && field[0][2] == USER_CELL) {
                System.out.println(USER_WIN);
                isPlay=false;
            }
            if (field[0][0] == USER_CELL && field[1][1] == USER_CELL && field[2][2] == USER_CELL) {
                System.out.println(USER_WIN);
                isPlay=false;
            }

            //условия победы компьютера
            if (field[0][0] == COMP_CELL && field[0][1] == COMP_CELL && field[0][2] == COMP_CELL) {
                System.out.println(COMP_WIN);
                isPlay=false;
            }
            if (field[1][0] == COMP_CELL && field[1][1] == COMP_CELL && field[1][2] == COMP_CELL) {
                System.out.println(COMP_WIN);
                isPlay=false;
            }
            if (field[2][0] == COMP_CELL && field[2][1] == COMP_CELL && field[2][2] == COMP_CELL) {
                System.out.println(COMP_WIN);
                isPlay=false;
            }
            if (field[0][0] == COMP_CELL && field[1][0] == COMP_CELL && field[2][0] == COMP_CELL) {
                System.out.println(COMP_WIN);
                isPlay=false;
            }
            if (field[0][1] == COMP_CELL && field[1][1] == COMP_CELL && field[2][1] == COMP_CELL) {
                System.out.println(COMP_WIN);
                isPlay=false;
            }
            if (field[0][2] == COMP_CELL && field[1][2] == COMP_CELL && field[2][2] == COMP_CELL) {
                System.out.println(COMP_WIN);
                isPlay=false;
            }
            if (field[2][0] == COMP_CELL && field[1][1] == COMP_CELL && field[0][2] == COMP_CELL) {
                System.out.println(COMP_WIN);
                isPlay=false;
            }
            if (field[0][0] == COMP_CELL && field[1][1] == COMP_CELL && field[2][2] == COMP_CELL) {
                System.out.println(COMP_WIN);
                isPlay=false;
            }
        }
    }
}