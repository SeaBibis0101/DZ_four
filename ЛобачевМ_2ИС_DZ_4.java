// Узел бинарного дерева
class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

// Класс бинарного дерева
public class BinaryTree<T> {
    private TreeNode<T> root;

    public BinaryTree() {
        this.root = null;
    }

    // Вставка элемента
    public void insert(T data) {
        root = insertRec(root, data);
    }

    private TreeNode<T> insertRec(TreeNode<T> root, T data) {
        if (root == null) {
            root = new TreeNode<>(data);
            return root;
        }

        // Простая вставка (можно реализовать логику сравнения для упорядоченного дерева)
        if (Math.random() < 0.5) {
            root.left = insertRec(root.left, data);
        } else {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    // Обход в порядке "in-order" (левый-корень-правый)
    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(TreeNode<T> root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }
    }

    // Обход в порядке "pre-order" (корень-левый-правый)
    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    private void preOrderTraversal(TreeNode<T> root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    // Обход в порядке "post-order" (левый-правый-корень)
    public void postOrderTraversal() {
        postOrderTraversal(root);
    }

    private void postOrderTraversal(TreeNode<T> root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data + " ");
        }
    }

    // Поиск элемента
    public boolean contains(T data) {
        return containsRec(root, data);
    }

    private boolean containsRec(TreeNode<T> root, T data) {
        if (root == null) {
            return false;
        }
        if (root.data.equals(data)) {
            return true;
        }
        return containsRec(root.left, data) || containsRec(root.right, data);
    }

    // Пример использования
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        
        // Вставляем элементы
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);

        // Выводим обходы
        System.out.println("In-order traversal:");
        tree.inOrderTraversal();
        System.out.println("Pre-order traversal:");
        tree.preOrderTraversal();
        System.out.println("Post-order traversal:");
        tree.postOrderTraversal();

        // Проверяем наличие элементов
        System.out.println("Contains 4: " + tree.contains(4));
        System.out.println("Contains 10: " + tree.contains(10));
    }
}
