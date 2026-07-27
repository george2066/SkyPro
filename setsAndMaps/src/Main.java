//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    List<Integer> nums = new ArrayList<>(List.of(1, 1, 2, 3, 4, 4, 5, 5, 6, 7));
    System.out.println("Example 1");
    for (Integer num : nums) {
        if (num % 2 == 1) {
            System.out.print(num + " ");
        }
    }
    System.out.println();
    System.out.println("Example 2");
    Set<Integer> numsSet = new HashSet<>(nums);
    nums = new ArrayList<>(numsSet);
    for (Integer num : nums) {
        if (num % 2 == 1) {
            System.out.print(num + " ");
        }
    }
    System.out.println();
    System.out.println("Example 3");
    List<String> strings = new ArrayList<>(List.of("один", "два","два", "три", "три", "три"));
    for (String string : strings) {
        if (Collections.frequency(strings, string) == 1) {
            System.out.println(string);
        }
    }
    System.out.println("Example 4");
    List<String> stringsUnique = new ArrayList<>(new HashSet<>(strings));
    for (String string : stringsUnique) {
        System.out.println(Collections.frequency(strings, string));
    }
}
