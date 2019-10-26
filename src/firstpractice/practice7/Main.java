package firstpractice.practice7;

import java.util.*;

/**
 * 从一列不重复的数中筛除尽可能少的数使得从左往右看，这些数是从小到大再从大到小的。
 * 如果有多种结果，按字典序排序。
 * @Author: wenjun
 * @Date: 2019/10/13 15:32
 */
public class Main {

    List<List<Integer>> listLeftTotal = new ArrayList<>();
    List<List<Integer>> listRightTotal = new ArrayList<>();
    List<Integer> listLeft = new ArrayList<>();
    List<Integer> listRight = new ArrayList<>();
    List<Integer> indexLeft = new ArrayList<>();
    List<Integer> indexRight = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = Integer.parseInt(scanner.nextLine());
        while (first-- > 0) {
            String second = scanner.nextLine();
            String[] split1 = second.trim().split(" ");
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < split1.length; i++) {
                list.add(Integer.parseInt(split1[i]));
            }
            new Main().result(list);
        }
    }

    public void result(List<Integer> list) {
        int size = 0;
        List<List<Integer>> lists = new ArrayList<>();
        List<List<Integer>> listsb = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            listLeftTotal.clear();
            listRightTotal.clear();
            listRight.clear();
            listLeft.clear();
            indexLeft.clear();
            indexRight.clear();
            List<List<Integer>> list1 = new ArrayList<>();
            List<List<Integer>> list2 = new ArrayList<>();
            list1 = maxLeftLength(list.subList(0,i+1));
            list2 = maxRightLength(list.subList(i,list.size()));
            if(list1.isEmpty()) lists.addAll(list2);
            if(list2.isEmpty()) lists.addAll(list1);
            for (int j = 0; j < list1.size();j++) {
                for (int k = 0; k < list2.size(); k++) {
                    List<Integer> list3 = new ArrayList<>();
                    list3.addAll(list1.get(j));
                    list3.remove(list3.size()-1);
                    list3.addAll(list2.get(k));
                    lists.add(list3);
                }
            }
        }
        for (int i = 0; i < lists.size(); i++) {
            size = Math.max(size,lists.get(i).size());
        }
        for (int i = 0; i < lists.size(); i++) {
            if(!listsb.contains(lists.get(i)) && lists.get(i).size() == size) {
                listsb.add(lists.get(i));
            }
        }
        Collections.sort(listsb, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                for(int i = 0; i < Math.min(o1.size(),o2.size());) {
                    if(String.valueOf(o1.get(i)).equals(String.valueOf(o2.get(i))))
                        i++;
                    else return String.valueOf(o1.get(i)).compareTo(String.valueOf(o2.get(i)));
                }
                return 0;
            }
        });
        for(int i = 0; i < listsb.size();i++) {
            for (int j = 0; j < listsb.get(i).size();j++) {
                if(j == listsb.get(i).size()-1)
                    System.out.print(listsb.get(i).get(j)+"\n");
                else System.out.print(listsb.get(i).get(j)+" ");
            }
        }
    }

    public List<List<Integer>> maxLeftLength(List<Integer> list1) {
        if(list1.isEmpty()) return listLeftTotal;
        int[] dpFirst = new int[list1.size()];
        int x = list1.get(list1.size()-1),maxFirst = Integer.MIN_VALUE;
        for (int i = 0; i < dpFirst.length-1; i++) {
            if(list1.get(i) < x) {
                dpFirst[i] = 1;
                for(int j = i-1; j >= 0; j--) {
                    if(list1.get(i) > list1.get(j)) {
                        dpFirst[i] = Math.max(dpFirst[i],dpFirst[j] + 1);
                    }
                }
            }
        }
        for(int key : dpFirst) {
            maxFirst = Math.max(maxFirst,key);
        }
        dpFirst[dpFirst.length-1] = maxFirst+1;
        listLeft.add(Integer.MIN_VALUE);
        indexLeft.add(-1);
        changeLeftToList(list1,dpFirst,1,maxFirst+1);
        return listLeftTotal;
    }

    public List<List<Integer>> maxRightLength(List<Integer> list1) {
        if(list1.isEmpty()) return listRightTotal;
        int[] dpFirst = new int[list1.size()];
        int x = list1.get(0),maxFirst = Integer.MIN_VALUE;
        dpFirst[0] = 1;
        for (int i = 1; i < dpFirst.length; i++) {
            if(list1.get(i) < x) {
                dpFirst[i] = 1;
                for(int j = 0; j < i; j++) {
                    if(list1.get(i) < list1.get(j)) {
                        dpFirst[i] = Math.max(dpFirst[i],dpFirst[j] + 1);
                    }
                }
            }
        }
        for(int key : dpFirst) {
            maxFirst = Math.max(maxFirst,key);
        }
        indexRight.add(0);
        listRight.add(list1.get(0));
        changeRightToList(list1,dpFirst,2,maxFirst);
        return listRightTotal;
    }

    public void changeLeftToList(List<Integer> list, int[] arr,int first,int max) {
        if(first > max) {
            if(!listLeftTotal.contains(listLeft)){
                List<Integer> listA = new ArrayList<>(listLeft);
                listA.remove(0);
                listLeftTotal.add(new ArrayList<>(listA));
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == first && list.get(i) > listLeft.get(listLeft.size()-1) && i > indexLeft.get(indexLeft.size()-1)) {
                listLeft.add(list.get(i));
                indexLeft.add(i);
                changeLeftToList(list,arr,first+1,max);
                listLeft.remove(listLeft.size()-1);
                indexLeft.add(i);
            }
        }
    }

    public void changeRightToList(List<Integer> list, int[] arr,int first,int max) {
        if(first > max) {
            if(!listRightTotal.contains(listRight))
                listRightTotal.add(new ArrayList<>(listRight));
        }
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] == first && list.get(i) < listRight.get(listRight.size()-1) && i > indexRight.get(indexRight.size()-1)) {
                listRight.add(list.get(i));
                indexRight.add(i);
                changeRightToList(list,arr,first+1,max);
                listRight.remove(listRight.size()-1);
                indexRight.add(i);
            }
        }
    }
}
