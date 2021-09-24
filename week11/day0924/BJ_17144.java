package week11.day0924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17144 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] map;
	static int R, C, T;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][] deltasUp = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int[][] deltasDown = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static Queue<Point> q;
	static int[][] clean;

	// 시뮬레이션 문제 -> 하라는대로 하기만 하면 됨.
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		q = new LinkedList<>();
		clean = new int[2][2];// 2개 각각 r,c
		int idx = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					clean[idx++] = new int[] { i, j };
				} else if (map[i][j] != 0 && map[i][j] != -1) {
					q.offer(new Point(i, j, map[i][j]));
				}
			}
		}
		int result = 0;
		do {
			// 1. 확산
			spread();

			// 2. 청소
			cleaning(0);

			cleaning(1);

			// 3. 미세먼지 위치 다시 넣기
			result = wnqwnq();// 줍줍

		} while (--T > 0);

		System.out.println(result);
	}

	private static void spread() {

		while (!q.isEmpty()) {
			Point now = q.poll();
			if (now.cnt >= 5) {
				int cnt = 0;
				int p = now.cnt / 5;
				for (int d = 0; d < deltas.length; d++) {
					int nr = now.r + deltas[d][0];
					int nc = now.c + deltas[d][1];
					if (isIn(nr, nc) && map[nr][nc] != -1) {
						map[nr][nc] = map[nr][nc] + p;
						cnt++;
					}
				}
				if (map[now.r][now.c] - p * cnt >= 0) {
					map[now.r][now.c] = map[now.r][now.c] - p * cnt;
				} else {
					map[now.r][now.c] = 0;
				}
			}
		}

	}

	private static void cleaning(int num) {
		Queue<Integer> cleanQ = new LinkedList<>();
		int[][] del;
		int[] cleaner = clean[num];// 0이 위에 1이 아래
		if (num == 0) {
			del = deltasUp;
		} else {
			del = deltasDown;
		}
		int r = cleaner[0];
		int c = cleaner[1];
		int nr = r;
		int nc = c;
		int d = 0;
		while (d < 4) {
			nr += del[d][0];
			nc += del[d][1];

			if (!isIn(nr, nc)) {
				nr -= del[d][0];
				nc -= del[d][1];
				d++;
				continue;
			}

			if (map[nr][nc] == -1) {
				d++;
				continue;
			}
			cleanQ.offer(map[nr][nc]);
			if (nr == r && nc == C - 1) {

				d++;
				continue;
			}
		}

		cleanQ.poll();
		cleanQ.offer(0);

		nr = r;
		nc = c;
		d = 0;
		while (d < 4) {
			nr += del[d][0];
			nc += del[d][1];

			if (!isIn(nr, nc)) {
				nr -= del[d][0];
				nc -= del[d][1];
				d++;
				continue;
			}

			if (map[nr][nc] == -1) {
				d++;
				continue;
			}
			map[nr][nc] = cleanQ.poll();
			if (nr == r && nc == C - 1) {

				d++;
				continue;
			}
		}

	}

	private static int wnqwnq() {
		int result = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != 0 && map[i][j] != -1) {
					result += map[i][j];
					q.offer(new Point(i, j, map[i][j]));
				}
			}
		}
		return result;
	}

	private static boolean isIn(int nr, int nc) {
		return 0 <= nr && nr < R && 0 <= nc && nc < C;
	}

	static class Point {
		int r, c;
		int cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}
}
