package _programmers.베스트앨범;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
	static class Music implements Comparable<Music> {
		int index;
		int play;
		
		public Music(int index, int play) {
			this.index = index;
			this.play = play;
		}
		
		@Override
		public int compareTo(Music m){
			return m.play - this.play;
		}
	}
	
	static class Genre implements Comparable<Genre> {
		String name;
		int playCount;
		List<Music> musics;
		
		public Genre(String name) {
			this.name = name;
			this.playCount = 0;
			this.musics = new ArrayList<>();
		}
		
		public void addMusic(Music music) {
			this.playCount += music.play;
			musics.add(music);
		}
		
		@Override
		public int compareTo(Genre g){
			return g.playCount - this.playCount;
		}
	}
	
	public int[] solution(String[] genres, int[] plays) {
		Map<String, Genre> genreMaps = new HashMap<>();
		
		for (int i = 0; i < genres.length; i++) {
			if (!genreMaps.containsKey(genres[i])) {
				genreMaps.put(genres[i], new Genre(genres[i]));
			}
			genreMaps.get(genres[i]).addMusic(new Music(i, plays[i]));
		}
		
		List<Integer> indexs = new ArrayList<>();
		
		List<Genre> genreList = genreMaps.values().stream().collect(Collectors.toList());
		Collections.sort(genreList);
		
		for (Genre genre:genreList) {
			List<Music> musics = genre.musics;
			Collections.sort(musics);
			indexs.add(musics.get(0).index);
			if (musics.size() > 1) {
				indexs.add(musics.get(1).index);
			}
		}
		
		Object[] trans = indexs.toArray();
		int[] answer = new int[trans.length];
		for (int i = 0; i < trans.length; i++) {
			answer[i] = (int) trans[i];
		}
		
		return answer;
	}
}