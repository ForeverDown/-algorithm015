package week1;

import java.util.Stack;

public class WaterTrap {
    public static void main(String[] args) {
        int[] heights = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(heights));

    }

    /*
    暴力求解，参考题解思路以后自行编写
    从当前位置分别向左向右遍历可获得的最高边界，取两边最高边界的较小值则获得了当前位置积水的最高高度
    再用积水最高高度减去当前位置的高度即为当前位置积水的实际高度（宽为1，则积水实际高度在数值上等于积水量）
    每次累加即可获得最终结果
     */
//    public static int trap(int[] heights) {
//        int area = 0;
//        int len = heights.length;
//        for (int i = 1; i < len - 1; ++ i) {
//            int leftMax = 0, rightMax = 0;
//            for (int j = i; j >= 0; -- j) {//向左寻找边界
//                leftMax = Math.max(leftMax, heights[j]);//更新左边界最大值
//            }
//            for (int j = i; j < len; ++ j) {//向右寻找边界
//                rightMax =Math.max(rightMax, heights[j]);//更新右边界最大值
//            }
//            area += (Math.min(leftMax, rightMax) - heights[i]);
//        }
//        return area;
//
//    }

    /*
    使用栈，来自题解
    来自作者：
    我们用栈保存每堵墙。当遍历墙的高度的时候，如果当前高度小于栈顶的墙高度，说明这里会有积水，我们将墙的高度的下标入栈。
    如果当前高度大于栈顶的墙的高度，说明之前的积水到这里停下，我们可以计算下有多少积水了。计算完，就把当前的墙继续入栈，作为新的积水的墙。
    当前高度小于等于栈顶高度，入栈，指针后移。当前高度大于栈顶高度，出栈，计算出当前墙和栈顶的墙之间水的多少，
    然后计算当前的高度和新栈的高度的关系，重复这一步。直到当前墙的高度不大于栈顶高度或者栈空，然后把当前墙入栈，指针后移。
     */
    public static int trap(int[] heights) {
        int area = 0;//保存结果
        Stack<Integer> stack = new Stack<Integer>();
        int current = 0;//指针
        while(current < heights.length) {//指针不到最后一位则一直循环
            while(!stack.empty() && heights[current] > heights[stack.peek()]) {
                int height = heights[stack.pop()];//出栈并保留出栈的元素
                if (stack.empty()) break;//若此时栈空就跳出
                int distance = current - stack.peek() - 1;//计算两点间距离
                int minHeight = Math.min(heights[stack.peek()], heights[current]);//取高度较小值
                area += distance * (minHeight - height);
            }
            stack.push(current);
            current ++;
        }
        return area;
    }
}
