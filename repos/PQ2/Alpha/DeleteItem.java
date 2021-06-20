package com.codebind;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class DeleteItem extends Dictionary
{
    public DeleteItem(DefaultListModel model, List<String> globalList, String delete)
    {
        boolean resume = true; int index = 0; boolean found = false;
        //This loop continues until either the item to be deleted is found within the list box
        //Or until all the elements within the list box (or binary tree) have been tested
        while(resume && index < globalList.size())
        {
            String part = model.get(index).toString();
            if(part.compareTo(delete) == 0 )
            {
                //If the delete criteria is found then the delete button removes the item in the listbox
                model.remove(index);
                //The item is also removed from the list box to be (put into the binary tree later)
                //Collections.sort(list,Collections.reverseOrder());
                globalList.remove(index);
                resume = false;
                found = true;
            }
            index++;
        }
        //If the delete text doesn't match display an error message
        if(found == false)
        {
            JOptionPane.showMessageDialog(null,
                    "Please enter valid part to delete");
        }
        //If the delete text is found within the listbox (binary tree)
        else
        {
            List<String> tempList = globalList;
            String[] names = new String[tempList.size()];
            //The array is sorted for the create balanced binary tree function which treats the array
            //like numbers in order, sorting the array allows each element to be added balancing the tree
            names = tempList.toArray(names);
            Arrays.sort(names);
            //This method has a return type however it is only needed within the function not outside
            //This is why no variable stores the return value
            tree.CreateBalancedTree(names,1,names.length);
            //This ensures that the binary tree is saved for the delete and search functions
            tempList.clear();
            tree.SetForSearch(tree.GetRoot());
            inOrder(tree.returnSearchRoot());
            //The root is reset for other arrays to be entered into the binary tree
            tree.SetRoot(null);
        }
    }
}
