package itis.grp403.TimurSibgatullin.HW3;

import java.util.List;
import java.util.ArrayList;

class NNode {
    int val;
    List<NNode> children;

    NNode(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }
}