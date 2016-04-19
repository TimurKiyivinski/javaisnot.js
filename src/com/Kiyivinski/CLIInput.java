package com.Kiyivinski;

import java.util.Scanner;

public class CLIInput extends Input{
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
