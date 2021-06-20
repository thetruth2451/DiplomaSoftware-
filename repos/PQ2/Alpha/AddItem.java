package com.codebind;

import javax.swing.*;
import java.util.Arrays;

public class AddItem extends Dictionary
{
    public AddItem(String add)
    {

        globalList.add(add);
        String[] names = new String[globalList.size()];
        names = globalList.toArray(names);
        //The array is sorted for the create balanced binary tree function which treats the array
        //like numbers in order, sorting the array allows each element to be added balancing the tree
        Arrays.sort(names);
        tree.CreateBalancedTree(names,1,names.length);
        //This ensures that the binary tree is saved for the delete and search functions

        tree.SetForSearch(tree.GetRoot());
        globalList.clear();
        inOrder(tree.returnSearchRoot());
        //The root is reset for other arrays to be entered into the binary tree
        tree.SetRoot(null);

    }
}
