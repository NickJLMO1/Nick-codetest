import java.util.ArrayList;
import java.util.HashMap;

public class DictionaryTree {

    private  HashMap<String,TreeNode>  treeElement = new HashMap<String, TreeNode>();


    public  HashMap<String, TreeNode> getTreeElement() {
        return treeElement;
    }


    public  TreeNode recursive(TreeNode rootNode, ArrayList<TreeNode> nodes)
    {
        treeElement.put(rootNode.getId(),rootNode);
        for(TreeNode treeNode :nodes)
        {
            if(treeNode.getParentId().equals(rootNode.getId()))
            {
                rootNode.getChildren().add(treeNode);

                recursive(treeNode, nodes);
            }

        }
        return rootNode;
    }

    public  TreeNode getRoot(ArrayList<TreeNode> nodes)
    {
        TreeNode root = null;
        if(nodes != null && nodes.size() > 0)
        {
            for (TreeNode treeNode : nodes)
            {
                if(treeNode.getParentId().endsWith(""))
                {
                    root = treeNode;
                    break;
                }
            }
        }
        return root;
    }

    public  TreeNode switchNodeListToTree(ArrayList<TreeNode> nodes)
    {
        TreeNode root = getRoot(nodes);
        root = recursive(root, nodes);
        return root;
    }

    public  HashMap<String,TreeNode>  getEndNodes()
    {
        HashMap<String,TreeNode>  endNodeList = new HashMap<String, TreeNode>();
        for(TreeNode node : treeElement.values())
        {
            if(node.getChildren().size() == 0)
            {
                endNodeList.put(node.getId(),node);
            }
        }
        return endNodeList;
    }

}
