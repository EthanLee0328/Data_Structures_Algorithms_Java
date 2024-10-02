package com.lee.data_structure;

public class SparseArray {
    public static void main(String[] args) {

//  1 二维数组 19*19   1行：3列是黑子【1】10列是白子【2】  10行：2列是黑子  19列是蓝子
        int[][] standard_go_chessboard = new int[19][19];
        standard_go_chessboard[0][2] = 1;
        standard_go_chessboard[0][9] = 2;
        standard_go_chessboard[9][1] = 1;
        standard_go_chessboard[9][18] = 2;

        System.out.println("原始的二维数组standard_go_chessboard 的样子");
        for (int i = 0; i < standard_go_chessboard.length; i++) {
            for (int j = 0; j < standard_go_chessboard[i].length; j++) {
                System.out.print(standard_go_chessboard[i][j] + "\t");
            }
            System.out.println();
        }

// 2 稀疏数组
// 2.1 创建稀疏数组 行：二维数组standard_go_chessboard的非零元素[即有效元素]个数+1[动态变化]

        int count = 0;

        for (int[] its : standard_go_chessboard) {
            for (int it : its) {
                if (it != 0) count++;
            }
        }

        int[][] sparse_array = new int[count + 1][3];

//        for (int[] its : sparse_array) {
//            for (int it : its) {
//                System.out.print(it+"\t");
//            }
//            System.out.println();
//        }

// 2.2  将 二维数组standard_go_chessboard的非零元素[即有效元素]写进稀疏数组sparse_array
        // 第一行是 standard_go_chessboard的信息 第一列是 standard_go_chessboard的行数 第二列是standard_go_chessboard的列数 第三列是standard_go_chessboard的非零元素[即有效元素]的个数
        sparse_array[0][0] = standard_go_chessboard.length;
        sparse_array[0][1] = standard_go_chessboard[0].length;
        sparse_array[0][2] = count;

        // 稀疏数组sparse_array中从第二列开始：
        // 列：第一列 是有效元素在standard_go_chessboard中的行 第二列：有效元素在standard_go_chessboard的列 第三列：有效元素在standard_go_chessboard中的值
        int row = 0;
        for (int i = 0; i < standard_go_chessboard.length; i++) {
            for (int j = 0; j < standard_go_chessboard[i].length; j++) {
                if (standard_go_chessboard[i][j] != 0) {
                    row++;
                    sparse_array[row][0] = i;
                    sparse_array[row][1] = j;
                    sparse_array[row][2] = standard_go_chessboard[i][j];
                }
            }
        }

        System.out.println("稀疏数组sparse_array的样子");

        for (int[] its : sparse_array) {
            for (int it : its) {
                System.out.print(it + "\t");
            }
            System.out.println();
        }


        // 3 将稀疏数组 复原为 二维数组

        int[][] from_sparse_array_to_two_dim_array = new int[sparse_array[0][0]][sparse_array[0][1]];

        for (int i = 1; i < sparse_array[0][2] + 1; i++) {
            from_sparse_array_to_two_dim_array[sparse_array[i][0]][sparse_array[i][1]] = sparse_array[i][2];
        }


        System.out.println("从稀疏数组复原后的二维数组的样子");
        for (int[] its : from_sparse_array_to_two_dim_array) {
            for (int it : its) {
                System.out.print(it + "\t");
            }
            System.out.println();
        }


    }
}
