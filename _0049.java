package Array;

import java.util.*;

/**
 * 字母异位词
 *算法有错，待修改，这题目很无聊，没有意义
 * @author yanxingyu 2512466437@qq.com
 * @version 2022/10/20 21:57
 */
public class _0049 {
    public static List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();//"a2b1c3"
            //根据键值找到对应的数组，如果没有就默认为（新建）
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        //想法一
        //找一个指针对它进行遍历
        //创建一个新的二维空数组
        //每遍历一个串，对其进行比对，
        //对于二维数组的每一维的第一个数组，比较两个串是否相似
        //若相似就加入当前数组
        //若不想死就新建一个数组
        //直到遍历结束
        List<List<String>> groups= new ArrayList<>();
        for (String str:strs) {
            int size=groups.size();
            if(size==0){
                List<String> g=new ArrayList<>();
                g.add(str);
                groups.add(g);
                continue;
            }
            for(int i=0;i<size;i++){
                String s=groups.get(i).get(0);
                if(Compare(s,str)){

                }
            }
        }
        return new ArrayList<List<String>>();
    }

    private static boolean Compare(String s, String str) {
        //判断两个字符串是否组成相同
        //一：遍历一个从另一个里删除字符
//        大神的思路，用质数表示26个字母，把字符串的各个字母相乘，这样可保证字母异位词的乘积必定是相等的。
//        其余步骤就是用map存储，和别人的一致了。（这个用质数表示真的很骚啊！！!）
        char[] chars=str.toCharArray();

        int[] visited=new int[s.length()];
        //Arrays.fill(visited,0);
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);

            //visited[index]=1;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums1={2,3,1,1,4};
        int[][] nums2={{1,2,3},{4,5,6},{7,8,9}};
        //groupAnagrams(nums2);
    }
}

