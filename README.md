# 配置
* kakazhu/3
* tempFilePath=D:\project\leetcode-demo\src\main\java
* check custom code template
* codeFileName=$!velocityTool.camelCaseName(${question.titleSlug})Test
* codeTemplate=
```
${question.content}

package leetcode.editor.cn;

public class $!velocityTool.camelCaseName(${question.titleSlug})Test {

    public static void main(String[] args) {
        System.out.println(new $!velocityTool.camelCaseName(${question.titleSlug})Test().new Solution());
    }

${question.code}
}
```
