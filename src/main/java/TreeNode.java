import java.util.ArrayList;

public class TreeNode {

    private String id;

    private String parentId;

    private ArrayList<TreeNode> children = new ArrayList<TreeNode>();

    private String data;

    public TreeNode(String id , String parentId, String data)
    {
        this.data = data;
        this.parentId = parentId;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public ArrayList<TreeNode> getChildren() {
        return children;
    }

    public String getData() {
        return data;
    }

    public String getParentId() {
        return parentId;
    }

}
