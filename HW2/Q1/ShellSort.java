import java.util.*;
public class ShellSort{
	public void sort(List<Integer> list, int[] gaps){
		int length = list.size();
		for(int gap: gaps){
			for(int i=gap; i<length; i++){
				int temp = list.get(i);
				int j;
				for(j = i;j>=gap && list.get(j-gap)>=temp;j-=gap)
					list.set(j,list.get(j-gap));
				list.set(j,temp);
			}
		}
	}
}
