package com.tian.leetcode.code.com.tian;

import java.util.*;

public class Test15 {

    public static void main(String[] args) {
        Test15 t = new Test15();
        List<List<Integer>> l = t.threeSum2(new int[]{3, -2, 1, 0});
        for (List<Integer> ls : l) {
            for (Integer i : ls) {
                System.out.print(i + " ,");
            }
            System.out.println();
        }
    }

    /**
     * 我的实现  超过时间限制
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        List<List<Integer>> ress = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int key = nums[i] + nums[j];
                List<List<Integer>> list = map.get(key);
                if (null == list) {
                    list = new ArrayList<>();
                }
                List<Integer> l = new ArrayList<>();
                l.add(i);
                l.add(j);
                list.add(l);
                map.put(key, list);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int cha = nums[i] * -1;
            List<List<Integer>> list = map.get(cha);
            if (null == list) continue;
            for (List<Integer> l : list) {
                if (!l.contains(i)) {
                    List<Integer> ll = new ArrayList<>();
                    ll.add(nums[i]);
                    ll.add(nums[l.get(0)]);
                    ll.add(nums[l.get(1)]);

                    ress.add(ll);
                }
            }
        }
        Set<List<Integer>> set = new HashSet<>();
        for (List<Integer> l : ress) {
            l.sort(new Comparator<Integer>() {
                public int compare(Integer n1, Integer n2) {
                    return n1.compareTo(n2);
                }
            });
            set.add(l);
        }
        ress = new ArrayList<>();
        ress.addAll(set);
        return ress;
    }

    /**
     * 第二种实现方法，也超出时间限制
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        if (nums.length < 3) return new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        Set<List<Integer>> sets = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i < nums.length - 2; i++) {
            int i1 = nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {
                int j1 = nums[j];
                i1 = nums[i];
                int cha = 0 - i1 - j1;
                if (j1 > i1) {
                    i1 = nums[j];
                    j1 = nums[i];
                }
                List<Integer> subList = set.subList(j + 1, nums.length);
                if (subList.contains(cha)) {
                    List<Integer> list = new ArrayList<>();
                    if (cha < j1) {
                        list.add(cha);
                        list.add(j1);
                        list.add(i1);
                    } else if (cha < i1) {
                        list.add(j1);
                        list.add(cha);
                        list.add(i1);
                    } else {
                        list.add(j1);
                        list.add(i1);
                        list.add(cha);
                    }
                    sets.add(list);
                }
            }
        }
        List<List<Integer>> aa = new ArrayList<>();
        aa.addAll(sets);
        return aa;
    }

    /**
     * 网上找到的方法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Set<Integer> set = new HashSet<Integer>();
        //排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            //判断有没有重复。
            if (!set.add(nums[i])) continue;
            //如果nums[i]大于0，就没有再判断的必要了
            if (nums[i] > 0) break;
            int head = i + 1;
            int tail = nums.length - 1;
            int last = nums[head];
            while (head < tail) {
                if (head != i + 1 && nums[head] == last) {
                    head++;
                    continue;
                }
                int sum = nums[i] + nums[head] + nums[tail];
                if (sum > 0) tail--;
                else if (sum < 0) {
                    last = nums[head];
                    head++;
                } else {
                    List<Integer> arrayList = new ArrayList<Integer>();
                    arrayList.add(nums[i]);
                    arrayList.add(nums[head]);
                    arrayList.add(nums[tail]);
                    list.add(arrayList);
                    last = nums[head];
                    head++;
                    tail--;
                }
            }
        }
        return list;
    }


    /**
     * 最快的方法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum4(int[] nums) {

        if (nums.length < 3)
            return Collections.emptyList();
        List<List<Integer>> res = new ArrayList<>();
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int negSize = 0;
        int posSize = 0;
        int zeroSize = 0;
        for (int v : nums) {
            if (v < minValue)
                minValue = v;
            if (v > maxValue)
                maxValue = v;
            if (v > 0)
                posSize++;
            else if (v < 0)
                negSize++;
            else
                zeroSize++;
        }
        if (zeroSize >= 3)
            res.add(Arrays.asList(0, 0, 0));
        if (negSize == 0 || posSize == 0)
            return res;
        if (minValue * 2 + maxValue > 0)
            maxValue = -minValue * 2;
        else if (maxValue * 2 + minValue < 0)
            minValue = -maxValue * 2;

        int[] map = new int[maxValue - minValue + 1];
        int[] negs = new int[negSize];
        int[] poses = new int[posSize];
        negSize = 0;
        posSize = 0;
        for (int v : nums) {
            if (v >= minValue && v <= maxValue) {
                if (map[v - minValue]++ == 0) {
                    if (v > 0)
                        poses[posSize++] = v;
                    else if (v < 0)
                        negs[negSize++] = v;
                }
            }
        }
        Arrays.sort(poses, 0, posSize);
        Arrays.sort(negs, 0, negSize);
        int basej = 0;
        for (int i = negSize - 1; i >= 0; i--) {
            int nv = negs[i];
            int minp = (-nv) >>> 1;
            while (basej < posSize && poses[basej] < minp)
                basej++;
            for (int j = basej; j < posSize; j++) {
                int pv = poses[j];
                int cv = 0 - nv - pv;
                if (cv >= nv && cv <= pv) {
                    if (cv == nv) {
                        if (map[nv - minValue] > 1)
                            res.add(Arrays.asList(nv, nv, pv));
                    } else if (cv == pv) {
                        if (map[pv - minValue] > 1)
                            res.add(Arrays.asList(nv, pv, pv));
                    } else {
                        if (map[cv - minValue] > 0)
                            res.add(Arrays.asList(nv, cv, pv));
                    }
                } else if (cv < nv)
                    break;
            }
        }
        return res;

    }
}
