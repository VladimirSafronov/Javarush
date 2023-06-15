package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.io.IOException;

public class Archiver {

    public static void main(String[] args) throws Exception {
        Operation operation = null;
        while (operation != Operation.EXIT) {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
            } catch (WrongZipFileException ex) {
                ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
            } catch (Exception ex) {
                ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
            }
        }
    }

    public static Operation askOperation() throws IOException {
        ConsoleHelper.writeMessage("Выберите операцию:\n" +
                "0 - упаковать файлы в архив\n" +
                "1 - добавить файл в архив\n" +
                "2 - удалить файл из архива\n" +
                "3 - распаковать архив\n" +
                "4 - просмотреть содержимое архива\n" +
                "5 - выход");
        int operationNumber = ConsoleHelper.readInt();
        Operation operation = null;
        switch (operationNumber) {
            case 0:
                operation = Operation.CREATE;
                break;
            case 1:
                operation = Operation.ADD;
                break;
            case 2:
                operation = Operation.REMOVE;
                break;
            case 3:
                operation = Operation.EXTRACT;
                break;
            case 4:
                operation = Operation.CONTENT;
                break;
            case 5:
                operation = Operation.EXIT;
                break;
        }
        return operation;
    }
}
