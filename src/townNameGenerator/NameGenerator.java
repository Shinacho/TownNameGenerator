/*
 * The MIT License
 *
 * Copyright 2016 Dra.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package townNameGenerator;

import java.util.Random;

/**
 * �n���������W�b�N.
 * <br>
 *
 * @version 1.0.0 - 2016/05/11<br>
 * @author Shinacho<br>
 * <br>
 */
public class NameGenerator {

	/**
	 * �g�p�\�ȕ���.
	 */
	private static final char[] CHARACTERS = "�^�h�R���C�L�X�M�[�J���~�z�}���V�S�����K�w�Y���x�g�؃��|�W�_��".toCharArray();

	/**
	 * �����Ɏg�p���郉���_��.
	 */
	private Random random;

	public NameGenerator() {
		random = new Random();
	}

	/**
	 * �w�肵�������́A�K���Ȗ��O�𐶐����܂��B. �g�p����镶���̈ꗗ�͎��̂Ƃ���ł��B<br>
	 * �C �J �L �R �V �X �^ �g �w �z �} �~ �� �� �� �� �� �� �� �� �K �M �S �W �Y �_ �h �x �� �| �[<br>
	 *
	 * @param length �������镶����̒����B1�ȏ���w��B
	 * @return �������ꂽ���O�B
	 */
	public String generate(int length) throws IllegalArgumentException {
		if (length <= 0) {
			throw new IllegalArgumentException("������1�ȏ�ł���K�v������܂��B");
		}
		StringBuilder str = new StringBuilder();
		char prev = ' ';
		for (int i = 0; i < length; i++) {
			char c = CHARACTERS[Math.abs(random.nextInt(CHARACTERS.length))];
			//�ŏ��̕�����"��"��"�["��������A"�["���A�������ꍇ�͍Đ���
			while ((i == 0 && (c == '��' || c == '�[')) || (prev == '�[' && c == '�[')) {
				c = CHARACTERS[Math.abs(random.nextInt(CHARACTERS.length))];
			}
			str.append(c);
			prev = c;
		}
		return str.toString();
	}
}
