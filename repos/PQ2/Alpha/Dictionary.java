package com.codebind;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class Dictionary {
    private JPanel MainPanel;
    private JList lstParts;
    private JTextField txtDelete;
    private JTextField txtAdd;
    private JTextField txtSearch;
    private JButton btnAdd;
    private JButton btnDelete;
    private JButton btnSearch;
    //Binary tree is global allowing DeleteItem and search functions to be updated from the insert method
    public static BinaryTree tree = new BinaryTree();
    //The search node is the returned node containing the searched string
    TreeNode searchNode = new TreeNode("");
    //A list is used to change the array because of the simple .Add feature which
    //Can be used regardless of having to refrence the index
    public static List<String> globalList = new ArrayList<String>();
    public static DefaultListModel newModel = new DefaultListModel();
    private String delete = "";
    private String add = "";
    int position = 0;



    public Dictionary()
    {
        //This function runs when the user fills the add textbox and presses the add button
        //The add button adds a name into the parts binary tree
        btnAdd.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Message displays if user forgets to enter data
                add = txtAdd.getText();
                if(add.equals(""))
                { JOptionPane.showMessageDialog(null,
                            "Please enter text to add to dictionary");
                }
                else { AddItem item = new AddItem(add);lstParts.setModel(newModel);}

            }
        });
        //This function runs when the user fills the delete textbox and presses the delete button
        //The delete button deletes a name from the parts binary tree
        btnDelete.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                delete = txtDelete.getText();
                if(delete.equals(""))
                {JOptionPane.showMessageDialog(null,
                            "Please enter valid text to delete from the dictionary");
                }
                else {DeleteItem item = new DeleteItem(newModel,globalList,delete);}
            }

        });
        //This function runs when the user fills the search text box and presses the search button
        //This button searches for a name within the parts  binary tree and returns the result.
        btnSearch.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(txtSearch.getText().equals(""))
                { JOptionPane.showMessageDialog(null,
                            "Please enter valid search criteria");
                }
                else
                {
                    String search = txtSearch.getText();
                    //This returns a node which is either null (meaning not found) or returns a filled in node with the search name
                    searchNode = tree.Search(search);
                    if(searchNode == null) { JOptionPane.showMessageDialog(null,
                                search + " not found");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,
                                search + " FOUND");
                    }
                }
            }
        });


    }

    public void inOrder(TreeNode node)
    {
        //This function populates the list box
        if(node == null){return;}
        inOrder(node.leftNode);

        globalList.add(node.name);
        newModel.clear();

        position = globalList.size() - 1;
        for(int index = 0; index <= position; index++)
        {
            newModel.addElement(globalList.get(index));
        }
        lstParts.setModel(newModel);

        //The List box is displayed in the same order as the balanced binary tree
        inOrder(node.rightNode);
    }
    public static void main(String[] args)
    {
        //This automaticaly creates the window and components when run
        JFrame Frame = new JFrame("Dictionary");
        Frame.setContentPane(new Dictionary().MainPanel );
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.pack();
        Frame.setVisible(true);
    }
}
