package itis.grp403.TimurSibgatullin.Stack;

import java.util.Stack;

public class Task4 {
    public static void main(String[] args) {
        int[] arr = {5, 4, 9, 7, 2};
        int n = arr.length;
        int[] result = new int[n];

        // Монотонный стек для поиска ближайшего меньшего слева
        Stack<Integer> stack = new Stack<>();

        // Первый проход: ищем ближайший меньший элемент слева
        for (int i = 0; i < n; i++) {
            // Ищем ближайший меньший элемент слева
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = -1; // Нет меньшего элемента слева
            } else {
                result[i] = stack.peek(); // Индекс ближайшего меньшего элемента слева
            }
            stack.push(i);
        }

        // Второй проход: ищем ближайший меньший элемент справа
        // Мы будем искать индексы ближайших меньших справа и проверять, где расстояние меньше
        for (int i = 0; i < n; i++) {
            // Индекс ближайшего меньшего элемента слева
            int leftIndex = result[i];

            // Теперь, для каждого элемента, ищем ближайший меньший справа
            int rightIndex = -1;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i]) {
                    rightIndex = j;
                    break;
                }
            }

            // Выбираем ближайший индекс между слева и справа
            if (leftIndex == -1 && rightIndex == -1) {
                result[i] = -1;
            } else if (leftIndex == -1) {
                result[i] = rightIndex;
            } else if (rightIndex == -1) {
                result[i] = leftIndex;
            } else {
                // Сравниваем расстояния
                if (Math.abs(i - leftIndex) <= Math.abs(i - rightIndex)) {
                    result[i] = leftIndex;
                } else {
                    result[i] = rightIndex;
                }
            }
        }

        // Выводим результат
        System.out.print("Результат ближайшего меньшего элемента: ");
        for (int res : result) {
            System.out.print(res + " ");
        }
        System.out.println();
    }
}
