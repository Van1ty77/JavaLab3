package ru.yurtaev.tree;

class Node {
    private Integer value;
    private Node parent;
    private Node left;
    private Node right;

    public Node() {
        this.value = null;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    public void addValue(int newValue) {
        if (value == null) {
            value = newValue;
        } else if (newValue <= value) {
            if (left == null) {
                left = new Node();
                left.parent = this;
            }
            left.addValue(newValue);
        } else {
            if (right == null) {
                right = new Node();
                right.parent = this;
            }
            right.addValue(newValue);
        }
    }

    public void removeValue(int targetValue) {
        if (value == null) return;

        if (targetValue == value) {
            if (left == null && right == null) {
                replaceWith(null);
            } else if (left != null && right == null) {
                replaceWith(left);
            } else if (left == null && right != null) {
                replaceWith(right);
            } else {
                Node successor = right.findMin();
                value = successor.value;
                successor.removeValue(successor.value);
            }
        } else if (targetValue < value && left != null) {
            left.removeValue(targetValue);
        } else if (targetValue > value && right != null) {
            right.removeValue(targetValue);
        }
    }

    public boolean containsValue(int targetValue) {
        if (value == null) return false;
        if (targetValue == value) return true;
        if (targetValue < value) {
            return left != null && left.containsValue(targetValue);
        } else {
            return right != null && right.containsValue(targetValue);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        collectValues(builder);
        return builder.toString();
    }

    private void collectValues(StringBuilder builder) {
        if (left != null) left.collectValues(builder);
        if (value != null) builder.append(value).append(" ");
        if (right != null) right.collectValues(builder);
    }

    private void replaceWith(Node replacement) {
        if (parent != null) {
            if (this == parent.left) {
                parent.left = replacement;
            } else {
                parent.right = replacement;
            }
        }
        if (replacement != null) replacement.parent = parent;
    }

    private Node findMin() {
        return left == null ? this : left.findMin();
    }
}