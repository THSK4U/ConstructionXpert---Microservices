package com.Microservices.projectmanagementservice;


/*
On vous donne un tableau d'entiers `nums`. Vous êtes initialement positionné au **premier index** du tableau, et chaque élément du tableau représente votre longueur de saut maximale à cette position.

Renvoie `true` *si vous pouvez atteindre le dernier index, ou* `false` *sinon*.

**Exemple 1 :**
Entrée : nums = [2,3,1,1,4]
Sortie : true
Explication : Sautez d'une étape de l'index 0 à 1, puis de 3 étapes jusqu'au dernier index.


**Exemple 2 :**
Entrée : nums = [3,2,1,0,4]
Sortie : false
Explication : Vous arriverez toujours à l'index 3 quoi qu'il arrive. Sa longueur de saut maximale est de 0, ce qui rend impossible l'atteinte du dernier index.

*/

public class test {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 1, 4};
        boolean r = Res(nums);
        System.out.print(r);


    }

    public static boolean Res(int[] nums) {
        int f = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > f) {
                return false;
            }
            f = Math.max(f, nums[i] + i);
        }
        return true;
    }
}