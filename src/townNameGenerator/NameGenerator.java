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
 * 地名生成ロジック.
 * <br>
 *
 * @version 1.0.0 - 2016/05/11<br>
 * @author Shinacho<br>
 * <br>
 */
public class NameGenerator {

	/**
	 * 使用可能な文字.
	 */
	private static final char[] CHARACTERS = "タドコロイキスギーカンミホマムシゴリラガヘズルベトぺレポジダメ".toCharArray();

	/**
	 * 生成に使用するランダム.
	 */
	private Random random;

	public NameGenerator() {
		random = new Random();
	}

	/**
	 * 指定した長さの、適当な名前を生成します。. 使用される文字の一覧は次のとおりです。<br>
	 * イ カ キ コ シ ス タ ト ヘ ホ マ ミ ム メ ラ リ ル レ ロ ン ガ ギ ゴ ジ ズ ダ ド ベ ぺ ポ ー<br>
	 *
	 * @param length 生成する文字列の長さ。1以上を指定。
	 * @return 生成された名前。
	 */
	public String generate(int length) throws IllegalArgumentException {
		if (length <= 0) {
			throw new IllegalArgumentException("長さは1以上である必要があります。");
		}
		StringBuilder str = new StringBuilder();
		char prev = ' ';
		for (int i = 0; i < length; i++) {
			char c = CHARACTERS[Math.abs(random.nextInt(CHARACTERS.length))];
			//最初の文字が"ン"や"ー"だったり、"ー"が連続した場合は再生成
			while ((i == 0 && (c == 'ン' || c == 'ー')) || (prev == 'ー' && c == 'ー')) {
				c = CHARACTERS[Math.abs(random.nextInt(CHARACTERS.length))];
			}
			str.append(c);
			prev = c;
		}
		return str.toString();
	}
}
