package com.jingdianxi.guessthewords;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessTheWords {

	// �������������鱣��ʿ�
	public static String[] str = { "apple", "bravo", "charlie", "delta", "echo", "fox", "apple", "banana", "cat", "dog", "egg", "element" };

	// ���ѡȡ����
	public static Random random = new Random();
	public static String word = str[random.nextInt(str.length)];

	// ��ʼ��Scanner�����
	public static Scanner scan = new Scanner(System.in);

	// ��ʼ���´ʴ���
	public static int chance = 5;

	// ��ʼ���´ʽ��
	public static String[] chars = new String[word.length()];

	public static void init() {
		// ��ʼ���´ʽ��Ϊ���ʳ��ȸ�����
		for (int i = 0; i < chars.length; i++) {
			chars[i] = "-";
		}
		// ����������Ϸ��ʼ
		output();
	}

	// ����´ʽ��
	public static void output() {
		// �����´ʽ�����鲢���ʣ�����
		for (int i = 0; i < chars.length; i++) {
			System.out.print(chars[i]);
		}
		System.out.println();
		System.out.println("����" + chance + "�λ���");
		input();
	}

	// ��ȡ�û��´���������
	public static void input() {
		String key = scan.nextLine();
		// �ж��û������Ƿ�Ϊ��ĸ
		if (key.length() != 1 || key.charAt(0) < 65 || (key.charAt(0) > 90 && key.charAt(0) < 97) || key.charAt(0) > 122) {
			// �������ĸ����ʾ��Ϣ�����²����û�����
			System.out.println("�����뵥����ĸ");
			input();
		} else {
			// ������ĸ���ж��û��´��Ƿ���ȷ
			check(key);
		}
	}

	// �ж��û��´��Ƿ���ȷ
	public static void check(String key) {
		if (word.indexOf(key.toLowerCase()) == -1) {
			// �´ʴ��󣬴�����һ
			chance--;
			// �ж�ʣ�����
			if (chance > 0) {
				// ʣ�������Ϊ0�������´�
				output();
			} else {
				// ʣ�����Ϊ0����Ϸ����
				over();
			}
		} else {
			// �´���ȷ����Ӧλ����ĸתΪ�ɼ�
			show(key);
		}
	}

	// ��ʾ�û��µ���ĸ
	public static void show(String key) {
		// ����Ŀ�굥��
		for (int i = 0; i < word.length(); i++) {
			// ���û��³���ĸתΪ�ɼ�
			if (word.charAt(i) == key.charAt(0)) {
				chars[i] = key;
			}
		}
		// �жϵ����Ƿ���ȫ�³�
		judge();
	}

	// �жϵ����Ƿ���ȫ�³�
	public static void judge() {
		// �ж��û��Ƿ���ȫ�³����ʣ����ж��û��´��������Ƿ����"-"
		if (Arrays.asList(chars).contains("-")) {
			// ��δ��ȫ�³����������ǰ����������´�
			output();
		} else {
			// ����ȫ�³�����´ʳɹ�
			goal();
		}
	}

	// �´ʳɹ�
	public static void goal() {
		System.out.println(word);
		System.out.println("�´ʳɹ�");
	}

	// �´�ʧ��
	public static void over() {
		System.out.println("�´�ʧ�ܣ���Ϊ" + word);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(word);
		init();
	}

}
