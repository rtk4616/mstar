int cd(int d, string a, string b, string c, int sum) {
    if (d == 1) {
        //println("move " + a + " --> " + c);
        sum++;
    } else {
        sum = cd(d - 1, a, c, b, sum);
        //println("move " + a + " --> " + c);
        sum = cd(d - 1, b, a, c, sum);
        sum++;
    }
    return sum;
}

int main() {
    string a = "A";
	string b = "B";
	string c = "C";
    int d = getInt();
    int sum = cd(d, a, b, c, 0);
    println(toString(sum));
    return 0;
}




/*!! metadata:
=== comment ===
hanoi-5100379110-daibo.mx
=== is_public ===
True
=== assert ===
output
=== timeout ===
1.5
=== input ===
27
=== phase ===
optim pretest
=== output ===
134217727
=== exitcode ===


!!*/

