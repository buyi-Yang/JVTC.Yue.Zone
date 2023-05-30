# 2.5 第二章复习

## 一、判断题（共5题，26分）

1. （判断题）（**B**）
$$
\Large
\because x \rightarrow 0 \text{时} \sin x \text{\textasciitilde} x \\
\therefore \lim\limits_{x \rightarrow \infty} \frac{\tan x - \sin x}{\sin^3 x}
    = \lim\limits_{x \rightarrow 0} \frac{x - x}{x^3} = 0
$$

- A. 对
- B. 错

----------

2. （判断题）（**A**）
$$
\Large
\lim\limits_{x \rightarrow 0} x \sin \frac{1}{x}
= \lim\limits_{x \rightarrow 0} · \lim\limits_{x \rightarrow 0} \sin \frac{1}{x}
= 0
$$

- A. 对
- B. 错

----------

3. （判断题）（**A**）
设 $f(x)$ 在 $[a, b]$ 上连续且无零点，则 $f(x)$ 在上 $[a, b]$ 恒为正或恒为负。

- A. 对
- B. 错

----------

4. （判断题）（**A**）
$\Large \frac{1}{x}$ 是无穷小

- A. 对
- B. 错

----------

5. （判断题）（**A**）
当 $x \rightarrow 0$ 时，$\sin 3x$ 与 $e^x - 1$ 是同阶无穷小。

- A. 对
- B. 错

## 二、简答题（共7题，36.4分）

6. （简答题）
求曲线 $\Large y = \frac{1}{|x|}$ 的渐进线。

----------

7. （简答题）
设函数
$
\Large
f(x) = \begin{cases}
    \frac{\sin 2x}{|x|}, & \text{当} x < 0 \\
    -2, & \text{当} x = 0 \\
    2x^2 - 2, & \text{当} 0 < x \leq 1 \\
    x, & \text{当} x > 1 \\
\end{cases}
$
，讨论 $f(x)$ 在 $x = 1$ 处的连续性。

解：
当 $x = 0$ 时：

$$
\large
\lim\limits_{x \rightarrow 0^-} f(x) = \lim\limits_{x \rightarrow 0^-} \frac{\sin 2x}{|x|} = 2 \\
\lim\limits_{x \rightarrow 0^+} f(x) = \lim\limits_{x \rightarrow 0^+} 2x^2 - 2 = -2 \\
\lim\limits_{x \rightarrow 0^-} f(x) \not= \lim\limits_{x \rightarrow 0^+} f(x) \\
$$

即 $f(x)$ 在 $x \geq 0$ 处不连续。

当 $x = 1$ 时：

$$
\large
\lim\limits_{x \rightarrow 1^-} f(x) = \lim\limits_{x \rightarrow 1^-} 2x^2 - 2 = 0 \\
\lim\limits_{x \rightarrow 1^+} f(x) = \lim\limits_{x \rightarrow 1^+} x = 1 \\
\lim\limits_{x \rightarrow 1^-} f(x) \not= \lim\limits_{x \rightarrow 1^+} f(x) \\
$$

即 $f(x)$ 在 $x = 1$ 处不连续。

----------

8. （简答题）
设 $f(x)$ 在 $[a, b]$ 上连续，且 $f(a) < a, f(b) > b$，<br />
证明：$f(x) = x$ 在 $(a, b)$ 内至少有一个根。

解：

$$
\large
\because \lim\limits_{x \rightarrow 0} \frac{1}{|x|} = \infty \\
\therefore x = 0 \text{为其垂直渐进线} \\
\because \lim\limits_{x \rightarrow \infty} \frac{1}{|x|} = 0 \\
\therefore y = 0 \text{为其水平渐进线}
$$

----------

9. （简答题）
设函数
$
\Large
f(x) = \begin{cases}
    x^2 + 1, & x < 0 \\
    x, & x \geq 0 \\
\end{cases}
$
，判断 $\Large \lim\limits_{x \rightarrow 0} f(x)$ 是否存在。

----------

10. （简答题）求下列函数的间断点：

$
\Large
\text{(1).} f(x) = \frac{1}{(x + 2)^2}
$
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
$
\Large
\text{(2).} f(x) = \begin{cases}
    \frac{\sin x}{x}, & x \not= 0 \\
    2, & x = 0 \\
\end{cases}
$

----------

11. （简答题）
设 $\Large \lim\limits_{x \rightarrow 1} \frac{x^2 + ax +b}{x^2 - 1} = 3$
求 $a$ 和 $b$。

----------

12. （简答题）
若 $x \rightarrow x_0$ 时，$\alpha(x)$ 与 $\alpha_1(x)$ 是等价无穷小，
$\alpha(x)$ 与 $\beta(x)$ 是同阶无穷小，但不是等价无穷小，
证明：$\alpha(x) - \beta(x)$ 与 $\alpha_1(x) - \beta(x)$ 也是等价无穷小。

解：

$$
\large
\text{由原题得出：} \\
\lim\limits_{x \rightarrow x_0} \frac{\alpha(x)}{\beta(x)} = 1,
    \text{即} \lim\limits_{x \rightarrow x_0} \alpha(x)
    = \lim\limits_{x \rightarrow x_0} \alpha(x)
    = \lim\limits_{x \rightarrow x_0} \alpha_1(x) \\
\because \lim\limits_{x \rightarrow x_0} \frac{\alpha(x)}{\beta(x)} = A,
    A \text{为常量且} A \notin \{ 0, 1 \} \\
\therefore \lim\limits_{x \rightarrow x_0} \alpha(x)
    \not= \lim\limits_{x \rightarrow x_0} \beta(x) \\
\therefore \lim\limits_{x \rightarrow x_0} \frac{\alpha(x) - \beta(x)}{\alpha(x) - \beta(x)} = 1
$$

## 三、计算题（共7题，37.6分）

13. $\Large\lim\limits_{x\rightarrow 0^+}\frac{\ln(1+x^3)·(1-cos\sqrt{x})}{\arcsin·(\sqrt{1-x^3}-1)}$
    <details>  -->
    <summary>题解</summary>
    
    在该极限中明显 X 趋于 0（无穷小），可直接根据无穷小转化公式 

    [ $\ln(1+x) ~ x$ ,
    $1 - \cos x \to ( \frac{1}{2} ) x^2, \arcsin x \to x$,
   
    $$
    \sqrt[n]{1+x^a}-1 \to \frac{1}{n}x^a
    $$
    ]

    转化后原式：

    $$
    \Large\lim\limits_{x \to 0^+}\frac{x^3·\frac{1}{2}(\sqrt{x})^2}{x·\frac{1}{2}(-x^3)}=-1

    $$
 
    </details>

14. $\Large\lim\limits_{x\rightarrow 0}\frac{e^{sin2x}-e^{sinx}}{x}$
    
    答案：![](./img/14T.png)

15.  $\Large\lim\limits_{x \rightarrow 0}\frac{1-cos2x}{xsinx}$  
    
    <details>
    <summary>题解</summary>

    $$
    \begin{align*}
        & \lim\limits_{x \rightarrow 0}\frac{1-cos2x}{xsinx} \\
        & = \lim\limits_{x \rightarrow 0}\frac{2sin^2x}{xsinx} \\
        & = 2 \lim\limits_{x \rightarrow 0}\frac{sinx}{x}=2 \\
    \end{align*}
    $$

    </details>

16.  $\Large\lim\limits_{x \rightarrow 1}\frac{x^2+2x-3}{\sqrt{x+3}-2}$

17. $\Large\lim\limits_{x \to \infty }{(\frac{3+x}{6+x})}^\frac{x-1}{2}$

18. $\Large\lim\limits_{x \to 1 }\frac{x^2-2x+1}{x^2-1}$

19. $\Large\lim\limits_{x \to +\infty}\frac{1+\sqrt{x}}{1-\sqrt{x}}$

