package com.chase.uitil;

import com.chase.model.Employee;
import com.chase.model.EmployeeData;

import java.util.*;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class NoteBook {

    public static int[] addElement(int[] data, int ele) {
        int[] result = Arrays.copyOf(data, data.length + 1);
        result[data.length] = ele;
        return result;
    }

    //1-1/3+1/5-1/7+1/9-...=pi4
    public static double find_PiValue_UpTo_Given_Number(int N) {
        System.out.println("$$$$$$---->");
        double piValue = 0.0;
        for(int i = 0; i < N; i++) {
            double sign = (i % 2 == 0) ? 1 : -1;
            double value = sign / (2 * i + 1);
            piValue += value;
        }
        return piValue * 4;
    }

    /*array లో ఒక position దగ్గర
    left elements sum = right elements sum అవుతుందా?

    index 3 (value = 4)
    left = 1 + 2 + 3 = 6
    right = 6
    👉 equal → answer = true
    */
    public static boolean balancedArray(int[] arr){ //int[]{1, 2, 3, 4, 6}
        int totalSum = 0;
        int leftSum = 0;
        boolean value = false;
        for(int i =0; i<arr.length; i++){
            totalSum += arr[i];
        }
        for(int i =0; i<arr.length;i++){
            totalSum = totalSum-arr[i];
            if(totalSum == leftSum){
                return true;
            }
            leftSum = leftSum+arr[i];
        }

        return value;
    }

    /*ఒక integer array మరియు ఒక target sum ఇచ్చినప్పుడు, continuous subarray (continuous elements) లో
    ఆ sum వస్తే, ఆ subarray starting & ending indices print చేయండి.*/
    public static void subArraySum(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            int currentSum = 0;
            for (int j = i; j < arr.length; j++) {
                currentSum += arr[j];
                if (currentSum == target) {
                    System.out.println("Found between index " + i + " and " + j);
                    return;
                }
            }
        }
        System.out.println("No subarray found");
    }

    public static void twoDimentionalArray(){
        int[][] arr = {
                {1,2,3}, // 3 2 1
                {4,5,6}, // 6 5 4
                {7,8,9}  // 9 8 7
        };
        for(int i = 0; i< arr.length; i++){
            for(int j = arr[i].length-1; j>=0; j--){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    /*
    * Buy on day 0 (100), sell on day 3 (310) → Profit = 210
    * Buy on day 4 (40), sell on day 6 (695) → Profit = 655
    * Total Profit = 210 + 655 = 865
    * */
    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            // If current price is higher than previous, add the difference
            if (prices[i] > prices[i - 1]) {
                //profit += prices[i] - prices[i - 1];
                int difference = prices[i] - prices[i - 1];
                profit = profit + difference;
            }
        }
        return profit;
    }

    public static void findAnagram(){
        String str1 = "be silent";
        String str2 = "be listen";
        String[] strChar1 = str1.replaceAll(" ","").split("");
        String[] strChar2 = str2.replaceAll(" ","").split("");
        System.out.println(Arrays.toString(strChar1));
        System.out.println(Arrays.toString(strChar2));
        Arrays.sort(strChar1);
        Arrays.sort(strChar2);
        System.out.println(Arrays.equals(strChar1,strChar2));
    }

    public void findStringLenghtWithOutLenghtFunctionByUsingJavaStream(){
        String str = "Hello World!";
        long count = str.chars().filter(Character::isLetter)
                .count();
    }

    public static void LongestSubstringWithoutRepeating (String str) { //input :: abccd Output :: 3 (abc)
        String value = "abcabcbb"; // or value = "a";
        char[] charArray = value.toCharArray();
        System.out.print(charArray[0]);
        for (int i = 0; i < charArray.length - 1; i++) {
            if (charArray[i + 1] - charArray[i] == 1) {
                System.out.print(charArray[i + 1]);
            } else {
                break;
            }
        }
    }

    public static boolean stringContainsVowels(String str) {
        //to remove aeiou
        //return input.replaceAll("aeiou","");
        return str.toLowerCase().matches(".*[aeiou].*");
    }

    public static void splitStirngAndIntegerArrayAndSum(){ //i/p : hello123 o/p:58
        String str = "hello123"; //output : 58 only
        String[] part = str.split("(?<=\\D)(?=\\d)");
        int sum =0;
        char[] chars1 = part[0].toCharArray();
        for(int i=0; i<chars1.length;i++){
            int a=Character.getNumericValue(chars1[i]);
            //System.out.print(a-9 + " ");
            sum = sum+(a-9);
        }
        char[] chars2 = part[1].toCharArray();
        for(int i=0; i<chars2.length;i++){
            int a=Character.getNumericValue(chars2[i]);
            sum = sum+a;
        }
        System.out.println(sum);
    }
    public static void validateMobileNumber(String str) {
        String regex1 = "^\\d{10}$"; // for regular 10 digit number validation
        // fo usa +1 720585433 : "^\\+1\\s\\d{10}$"
        Pattern pattern = Pattern.compile(regex1);
        Matcher matcher = pattern.matcher(str);
        boolean matches = matcher.matches();
        System.out.println(matches);
    }

    public static boolean isBalanced(String str) {
        while (str.contains("()") || str.contains("[]") || str.contains("{}")) {
            str = str.replaceAll("\\(\\)", "")
                    .replaceAll("\\[\\]", "")
                    .replaceAll("\\{\\}", "");
        }
        return (str.length() == 0);
    }

    public static void Take_each_value_and_calculate_the_sum_of_its_digits_in_ascending_order(){
        String strValues = "56 65 74 100 99 68 86 180 90"; // output: 100 180 90 56 65 74 68 86 99
        Map<String,Integer> map = new LinkedHashMap<>();
        String[] str = strValues.split(" ");

        for(int i =0; i<str.length; i++){
            String value = str[i];
            int sum = 0;
            for (int j =0; j<value.length(); j++){
                char c = value.charAt(j);
                int numericValue = Character.getNumericValue(c);
                sum = sum+numericValue;
            }
            map.put(value,sum);
        }
        System.out.println(map);
        List<String> actValues = map.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (o, v) -> o, LinkedHashMap::new))
                .entrySet()
                .stream()
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(actValues);
    }
    public static void getNameWithLength(){
        String str = "mani kumar panith arya prasanth suhan sudha";
        Map<String, Integer> collect = Arrays.asList(str.split(" ")).stream().collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println(collect);
    }

    /*Given ఒక array లో, ఒక specific number (num) ఎంత maximum consecutive (continuous) సార్లు వచ్చింది?*/
    public static void max_Consecutive_Given_number(int num) {
        int[] arr = {1,1,0,2,3,1,1,1};
        int max =0;
        int count =0;
        for(int i =0; i<arr.length; i++){
            if(arr[i] == num){
                count = count+1;
                max = Math.max(max,count);
            }else {
                count =0;
            }
        }
        System.out.println(max);
    }

    /*ఒక integer array మరియు ఒక target sum ఇచ్చినప్పుడు, continuous subarray (continuous elements) లో
    ఆ sum వస్తే, ఆ subarray starting & ending indices print చేయండి.*/
    public static void subArraySum1(int arr[], int sum) {
        for (int i = 0; i < arr.length; i++) {
            int currentSum = arr[i];
            if (currentSum == sum) {
                System.out.println("Sum found at indexe " + i);
                return;
            }
            else {
                for (int j = i + 1; j < arr.length; j++) {
                    currentSum = currentSum+ arr[j];
                    if (currentSum == sum) {
                        System.out.println("Sum found between indexes " + i + " and " + j);
                        return;
                    }
                }
            }
            //with chunk
            //for(int i =0; i<arr.length; i=i+chunck){
            //Last chunk lo out of bounds avoid చేయడానికి Math.min() use చేస్తారుZZZZZZZZZZZZZZZZZZZZZZZZ
             //list.add(Arrays.copyOfRange(arr,i,Math.min(arr.length, i+chunck));
            // }
            //another way of adding elements in array
            /*List<int[]> result = new ArrayList<>();
            for (int i = 0; i <= arr.length - 3; i++) {
                List<Integer> subarray = new ArrayList<>();
                subarray.add(arr[i]);
                subarray.add(arr[i + 1]);
                subarray.add(arr[i + 2]);
                result.add(subarray.stream().mapToInt(Integer::intValue).toArray());
            }
            System.out.println(result);
            for(int[] a : result){
                if(a[0]+a[1]+a[2] == sum){
                    System.out.println("got array");
                    System.out.println(Arrays.toString(a));
                    break;
                }
            }*/
        }
        System.out.println("No subarray found");
        return;
    }



    //recursion nerchukune time lo edi adugutaru.
    public static void printPermutation(String input, String output){
        if(input.length() == 0){
            System.out.print(output + " ");
            return;
        }
        for(int i =0; i<input.length(); i++){
            char ch = input.charAt(i);
            String rest = input.substring(0, i) + input.substring(i + 1);
            printPermutation(rest, output+ch);
        }
    }

    //Recursion
    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    //java 8 lo
    public static int factorialStream(int n) {
        return IntStream.rangeClosed(1, n)     // 1, 2, 3, ..., n
                .reduce(1, (a, b) -> a * b);   // 1 * 2 * 3 * ... * n
    }
    public static void recursionByUsingJava8(){
        IntUnaryOperator[] fact = new IntUnaryOperator[1];
        fact[0] = n -> n <= 1 ? 1 : n * fact[0].applyAsInt(n - 1);
        System.out.println("5! = " + fact[0].applyAsInt(5));
    }

    public static void sortStrings(){
        String names[] = { "Rahul", "Ajay", "Gourav", "Riya" };
        for (int i = 0; i < names.length; i++) {
            for (int j = i + 1; j < names.length; j++) {
                if (names[i].compareTo(names[j]) > 0) {
                    String temp = names[i];
                    names[i] = names[j];
                    names[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(names));
    }

    public static void checkStringPalandramOrNot(String str){
        int lengthMinuesOne = str.length()-1;
        boolean bo = IntStream.range(0, str.length())
                .allMatch(index -> str.charAt(index) == str.charAt(lengthMinuesOne - index));
        System.out.println(bo);
    }

    public static void reverseLinkedListInjava(){
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        System.out.println(ll);
        LinkedList<Integer> ll1 = new LinkedList<>();
        ll.descendingIterator().forEachRemaining(ll1::add);
        System.out.println(ll1);
    }

    public static void ArraySortAssAndDesc(){
        int[] arr = {8,1,7,2,3,9};
        for(int i=0; i<arr.length; i++){
            for(int j = i+1; j<arr.length;j++){
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void removeDuplicates(int[] arr) { //1,2,2,3,4,4,5

        //Input:  [1, 2, 2, 3, 4, 4, 4, 5]
        //Output: [1, 2, 3, 4, 5]

        int[] data = new int[0];

        data = addElement(data,arr[0]);
        for(int i =1; i<arr.length; i++){
            if(arr[i] != arr[i-1]){
                data = addElement(data,arr[i]);
            }
        }
        data = addElement(data, arr[arr.length - 1]);
        System.out.println(Arrays.toString(data));

        System.out.println("-----------------------");
        int[] input = { 1, 1, 2, 3, 5, 5, 7, 9, 9, 9 };
        int[] array = IntStream.of(input).distinct().toArray();


    }

    public static void findNonRepeatingElement() {
        //Input:  [1, 2, 2, 3, 4, 4, 4, 5]
        //Output: [1, 3, 5]  // ఎందుకంటే 2 మరియు 4 duplicates
        int[] arr = {8,1,7,2,3,9};
        for(int i = 0; i < arr.length; i++) {
            int count = 0;
            for(int j = 0; j < arr.length; j++) {
                if(arr[i] == arr[j]) {
                    count++;
                }
            }
            if(count == 1) {
                System.out.println(arr[i]);
            }
        }

        System.out.println("------------------------");
        int[] input = { 1, 1, 2, 3, 5, 5, 7, 9, 9, 9 };
        int[] array = Arrays.stream(input)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .mapToInt(Integer::intValue)
                .toArray();
        System.out.println(Arrays.toString(array));

    }

    public static void removeGivenElementFromArray(int[] arr, int key) {
        int[] array = Arrays.stream(arr).boxed()
                .filter(val -> val != key)
                .mapToInt(Integer::intValue)
                .toArray();
        System.out.println(Arrays.toString(array));
    }

    public static void getRandomNum(){
        Random random = new Random();
        for(int i =0; i<5; i++){
            System.out.println(random.nextInt());
        }
    }
    public static void reversArray(){
        int[] arr = {1,2,3,4,5};
        for (int i = 0; i < arr.length/2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static boolean areConsecutive() {
        //step 1 : do the array accending sort
        int[] arr = {1, 2, 3, 4, 5};
        //Arrays.sort(arr);
        for(int i =0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i]>arr[j]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i+1]-arr[i]!= 1)
                return false;
        }
        return true;
    }

    public static void findMissingNumbers() {
        int[] arr = {1, 2, 4, 6};  // Given array
        int N = 6;  //range
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        List<Integer> missingNumbers = IntStream.rangeClosed(1, N)
                .filter(num -> !list.contains(num)) // Keep numbers not in the array
                .boxed() // Convert primitive int to Integer (wapper class)
                .collect(Collectors.toList());
        System.out.println(missingNumbers);
    }
    public static int findNearestNumber(int[] numbers, int tarNum) {
        Integer nearElement = Arrays.stream(numbers).boxed()
                .min(Comparator.comparingInt(ele -> Math.abs(ele - tarNum)))
                .get();
        System.out.println(nearElement);
        return nearElement;
    }

    public static void findCommonElementsFrom2Arrays(){
        int[] arr1 = { 1,9,2,3,6,4,5,8,7};
        int[] arr2 = { 1,6,4,7,12};
        for(int i = 0; i<arr1.length; i++){
            for(int j = 0; j<arr2.length; j++){
                if(arr1[i] == arr2[j]){
                    System.out.println(arr1[i]);
                }
            }
        }

        int[] arr11 = { 1,9,2,3,6,4,5,8,7};
        int[] arr22 = { 1,6,4,7,12};
        int[] array = Stream.of(arr11, arr22)
                .flatMapToInt(ar -> Arrays.stream(ar))
                .boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(ent -> ent.getValue() == 1)
                .map(Map.Entry::getKey)
                .mapToInt(Integer::intValue)
                .toArray();
        System.out.println(Arrays.toString(array));
    }


    public static void test_Map_Merge_Sort_Hieghest_Salary_Department_Name_Revers_Map() {
        // a = 1, b = 3, c =1, d = 2, e = 1, f=2, g=3
        String value = "abbbcddeffggg"; // a = 1, b = 3, c =1, d = 2, e = 1, f=2, g=3
        String gettingValue = Arrays.asList(value.split(""))
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .skip(1)
                .findFirst()
                .map(Map.Entry::getKey)
                .get();
        System.out.println(gettingValue);
        System.out.println("------------------------");

        //Merge 2 maps
        Map<String, Integer> m1 = new HashMap<>();
        m1.put("A",1);
        m1.put("B",2);
        m1.put("C",3);
        Map<String, Integer> m2 = new HashMap<>();
        m2.put("D",4);
        m2.put("E",5);
        m2.put("F",6);
        HashMap<String, Integer> mergeMaps = Stream.of(m1, m2)
                .map(Map::entrySet)
                .flatMap(Collection::stream)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (ov, nw) -> ov, HashMap::new));
        System.out.println(mergeMaps);

        System.out.println("-----------------");
        //sort map and revers sort of map
        Map<String, Integer> map33 = new HashMap<>();
        map33.put("mani",40);
        map33.put("ratna",39);
        map33.put("evan",5);
        map33.put("ethan",3);

        map33.entrySet().stream()
                .sorted(Map.Entry.<String,Integer>comparingByKey().reversed())
                .forEach(System.out::println);
        System.out.println("-----------------------");

        //top or highest salary of employee for each department
        Employee e1 = new Employee(1, "mani", 500, "it");
        Employee e2 = new Employee(2, "kumar", 500,"develop");
        Employee e3 = new Employee(6, "arya", 700,"manager");
        Employee e4 = new Employee(3, "prasanth", 800,"manager");
        Employee e5 = new Employee(5, "suhan", 900,"production");
        Employee e6 = new Employee(7, "sudha", 900,"uat");

        //top or highest salary of employee for each department
        //Best solution
        //Note : first get the value(collect) after that do function
        /*Step 1: groupingBy → department wise groups create avutayi
        IT → [e1, e4, e6]
        HR → [e2, e5]
        Sales → [e3]

        Step 2: originalCollector (maxBy) → prathi group lo max salary employee
        IT → Optional<Employee(e4)>
        HR → Optional<Employee(e2)>
        Sales → Optional<Employee(e3)>

        Step 3: afterFunction → Optional<Employee> → salary extract
        IT → 90000.0
        HR → 65000.0
        Sales → 120000.0

        Step 4: Final Map
        {
            "IT" = 90000.0,
            "HR" = 65000.0,
            "Sales" = 120000.0
        }

        */
        Map<String, Double> collect = Arrays.asList(e1, e2, e3, e4, e5, e6).stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
                                emp -> emp.get().getSalary())));
        System.out.println(collect);
        System.out.println("------------------------------------");

        //create unmodifieable list
        List<String> namesList = Arrays.asList("mani", "ratna", "evan", "ethan");
        List<String> immutableNames = namesList.stream()
                .filter(name -> name.startsWith("m") || name.startsWith("r")) // Filter names starting with A or B
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        Collections::unmodifiableList // Transform to an unmodifiable list
                ));
        System.out.println("------------------------------------");

        //sort employee names with depatment wise
        Employee e11 = new Employee(1, "mani", 500,"it");
        Employee e22 = new Employee(2, "kumar", 500,"hr");
        Employee e33 = new Employee(6, "arya", 700,"it");
        List<Employee> listOfEmp = new ArrayList<>();
        listOfEmp.add(e11);
        listOfEmp.add(e33);
        listOfEmp.add(e22);

        Map<String, List<Employee>> collect1 = listOfEmp.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.collectingAndThen(
                                        toList(),
                                        empList -> empList.stream().sorted(Comparator.comparing(Employee::getName))
                                                .collect(toList())
                                )
                        ));

        System.out.println(collect1);
        listOfEmp.sort(Comparator.comparing(Employee::getSalary, Comparator.reverseOrder()).thenComparing(Employee::getName));
        System.out.println(listOfEmp);

    }

    public static void streamNonRepeatedElements(){
        List<Integer> myList = Arrays.asList(1, 1, 2, 2, 3, 4, 5);
        List<Integer> result = myList.stream()
                .filter(i -> Collections.frequency(myList, i) == 1)
                .collect(Collectors.toList());
        System.out.println(result);// [3, 4, 5]

        //for reUse purpose we have to follow the below line code.
        //Supplier<List<EmployeeData>> empList = ()->getEmployeeList();
    }

    public static void rankOfTheElement(){
        //[10, 8, 15, 12, 6, 20, 1]
        //[1+0=1, 8, 1+5=6, 1+2=3, 6, 2+0=2, 1]
        //final => [10,1,15,6,12,8]
        int[] arr = {10, 8, 15, 12, 6, 20, 1};
        Map<Integer, Integer> map = new HashMap<>();
        for(int val : arr){
            int num = val;
            int sum = 0;
            while (val > 0){
                int digit = val%10;
                sum = sum+digit;
                val = val/10;
            }
            System.out.println(sum);
            map.put(num,sum);
        }
        int[] val = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(val));
    }

    public static void sortListOfEmployeeByName() {
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(11, "mani", 500,"it"));
        empList.add(new Employee(22, "kumar", 1000,"it"));
        empList.add(new Employee(1, "arya", 1500,"it"));
        empList.add(new Employee(11, "sudha", 1700,"it"));
        //Use this way, it's very easy
        List<Employee> empByName = empList.stream()
                .sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
        System.out.println(empByName);
    }

    public static void getHighestSalary(){
        Employee e1 = new Employee(1, "mani", 500,"it");
        Employee e2 = new Employee(2, "kumar", 500,"it");
        Employee e3 = new Employee(6, "arya", 700,"it");

        //it's for getting Employee Object for getting 2nd hightest Salary.
        Employee employee = Arrays.asList(e1, e2, e3).stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(1)
                .findFirst()
                .get();
        System.out.println(employee.toString());

        //it's for getting value of primitive data type
        Double salary = Arrays.asList(e1, e2, e3).stream()
                .map(Employee::getSalary)
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();
    }

    public static void longestString(String[] input) {
        String longestString = Arrays.stream(input)
                .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2).get();
        System.out.println(longestString);
    }

    public static void streamAreNotReUseble(){
        // Stream are not reuse, it will throw "IllegalStateException"
        //How reuse the stream :: Supliyer
        Supplier<List<EmployeeData>> empList = () -> getEmployeeList();
    }

    public static void checkException(){
        try {
            int i = 10/0;
            System.out.println("from try");
        }catch (Exception ex){
            System.out.println("from catch block");
        }/*catch (*//*ArithmeticException ae*//*){
            System.out.println("from ae");               //compile time error
        }*/                                           //because "Exception" should write in last only
    }

    public static int[] mergeArray(int[]... intArrays) {
        return Arrays.stream(intArrays)
                .flatMapToInt(arr -> Arrays.stream(arr))
                .toArray();
    }


    public static void getCommonElementsFromTwoArrays(){
        int[] ar = {5,7,2,1,3,9};
        int[] arr = {4,7,2,1,8,9};

        int[] commonIntArray = Arrays.stream(ar).filter(num1 -> Arrays.stream(arr).anyMatch(num2 -> num2 == num1)).toArray();
        System.out.println(Arrays.toString(commonIntArray));

        List<Integer> commonElements = Arrays.stream(IntStream.concat(Arrays.stream(ar), Arrays.stream(arr)).toArray())
                .boxed()
                .collect(Collectors.toList())
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        //System.out.println(commonElements);
    }
    public static void sumOfEvenAndOddNumbersInASingleLine(){
        int[] arr = {1,2,3,4,5,6};
        Arrays.stream(arr).boxed()
                .collect(Collectors.partitioningBy(e -> e % 2 != 0, Collectors.summingInt(Integer::intValue)))
                .entrySet()
                .stream()
                .map(entry -> entry.getValue())
                .collect(Collectors.toList()).forEach(System.out::println);
    }

    public static void evenNumsLeftAndOddNumsRightSaid(){
        int[] arr = {1,2,3,4,5,6};
        List<Integer> collect = Arrays.stream(arr).boxed()
                .collect(Collectors.partitioningBy(e -> e % 2 != 0))
                .entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .flatMap(l -> l.stream())
                .collect(toList());
        System.out.println(collect);
    }

    public static void removeNegativeValuesFromArray(int[] arr) {
        int[] ints = Arrays.stream(arr).boxed().filter(ele -> ele  >0)
                .mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(ints));
    }
    public static void moveNegativeValuesAtFirstOfArray(){
        int[] negNums = new int[]{-1,2,-3,9,-8,7};
        int[] ints = Arrays.stream(negNums).boxed()
                .collect(Collectors.partitioningBy(e -> e < 0))
                .entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .flatMap(list -> list.stream())
                .mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(ints));
    }
    public static void clockCheck() {
        String source = "mani";
        String input = "ainm";
        System.out.println(((source+source).contains(input)));
    }
    public static int[] rotLeft(int[] arr, int ele) {
        /*if (ele == 0 || arr == null || arr.length == 0) {
            return arr;
        }*/
        //simple solution
        List<Integer> list = Arrays.stream(arr).boxed().collect(toList());
        Collections.rotate(list, ele); //posgetive number mean left rotation
        Collections.rotate(list, -4); //neagetive number mean right rotation
        //---------------------------------------
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[(i +ele) % arr.length];
        }
        System.out.println(Arrays.toString(newArr));

        return newArr;
    }
    public static int[] rotRight(int[] arr, int ele) {
        System.out.println(ele);
        int[] newArr = new int[arr.length];
        for (int i = 0; i <= arr.length-1; i++) {
            newArr[(i + ele) % arr.length] = arr[i];
        }
        System.out.println(Arrays.toString(newArr));
        return newArr;
    }
    public static void reverseNumber(int num) {
        int revers = 0;
        while (num != 0) {
            int digit = num % 10;
            revers = revers * 10 + digit;
            num = num / 10;
        }
        System.out.println(revers);
        String s = num + "";
        StringBuffer sb = new StringBuffer(s);
        StringBuffer reverse = sb.reverse();
        System.out.println("sB " + Integer.valueOf(revers));
    }
    public static int reverseNumbers(int num) {
        // Convert to String → Stream → Reverse → Back to int
        String reversed = String.valueOf(Math.abs(num))  // "12345"
                .chars()                                      // IntStream of characters
                .mapToObj(c -> (char) c)                     // Stream<Character>
                .reduce("", (f, s) -> s + f, (f1, s1) -> s1 + f1);  // Reverse using reduce

        int result = Integer.parseInt(reversed);
        return num < 0 ? -result : result;
    }

    //Exception in thread "main" java.lang.UnsupportedOperationException
    public static void removeElementFromArray(int[] ints, int value) {
        List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
        list.remove(Integer.valueOf(3));

        int[] intsValue = list.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(list);
    }

    //Collector.toMap(Function fun, Function fun)
    public static void TwoStringsSplitAndAdd() {
        List<String> strList = new ArrayList<>();
        strList.add("Key1:1,2,3");
        strList.add("Key2:5,6,7");

        Map<String, List<String>> collect =
                strList.stream()
                        .collect(Collectors.toMap(str -> str.split(":")[0],
                                str -> Arrays.stream(str.split(":")[1].split(","))
                                        .collect(Collectors.toList())));
        System.out.println(collect);
        System.out.println(collect.size());
    }
    public static void fibonacciTest(int num) {
        int a = 0, b = 1;
        System.out.print(a + " " + b + " ");
        for (int i = 2; i < 10; i++) {
            int c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }

    }

    public static boolean isPrime(int num) {
        if (num == 0)
            return false;
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }



    public static void findStartWithOne() {
        List<Integer> list = Arrays.asList(1, 3, 44, 12, 55, 33, 11, 72, 18);
        list.stream().map(element -> element + "")
                .filter(str -> str.startsWith("1"))
                .sorted()
                .forEach(System.out::println);
    }
    public static void nonRepeatCharacter() {
        String s1 = "hi this is mani";
        String s2 = "and this is testing";
        //find the non Repeat Character
        String input = (s1+s2).replaceAll(" ", "");

        //find the non Repeat Characters list
        List<String> collect = Arrays.asList(input.split("")).stream()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                //.sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        //convert list to String[] java 11 feature
        String[] strings = collect.stream().toArray(String[]::new);
        System.out.println(collect);
    }
    public static void reverseAList() {
        List<Integer> listInt = new ArrayList<>();
        listInt.add(11);
        listInt.add(1);
        listInt.add(93);
        listInt.add(44);
        System.out.println(listInt);
        //listInt.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
        listInt.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
    public static void reversStringWordByWord() {
        String collect = Arrays.asList("Hello World".split(" "))
                .stream()
                .map(word -> new StringBuffer(word).reverse())
                .collect(Collectors.joining(" "));
        System.out.println(collect);
    }

    public static void findMaxElement() {
        int[] arr = {1, 5, 3, 2, 6, 9, 11, 5, 22};
        int asInt = IntStream.of(arr).max().getAsInt();
        System.out.println(asInt);
    }
    public static void sortEmpList() {
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(11, "mani", 500,"it"));
        empList.add(new Employee(22, "kumar", 1000,"it"));
        empList.add(new Employee(1, "arya", 1500,"it"));
        empList.add(new Employee(11, "sudha", 1700,"it"));

        //If we want to use comparTo method then we have to override "compareTo" method in your Employee class.
        //empList.stream().sorted((e1,e2) -> e1.compareTo(e2)).forEach(System.out::println);

        double salary = empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(1)
                .findFirst()
                .get().getSalary();
        System.out.println(salary);
    }
    public static void groupingWordsByLength() {
        List<String> list = Arrays.asList("mani", "kumar", "panithi", "arya", "panithi", "sudha");

        Map<Integer, List<String>> numList = list.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(numList);

        //output:: sudha :: 1
        //         arya :: 1
        list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((k, v) -> System.out.println(k + " :: " + v));

        //4=[mani, arya]
        //5=[kumar, sudha]
        //7=[panithi, panithi]
        list.stream().collect(Collectors.groupingBy(String::length)).entrySet().stream().collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public static void findMejorityElementFromGivenArray(){
        try{
            int[] i = {1,2,4,4,4,4,4,5,7,8,9};
            Integer mejorityElement = Arrays.stream(i).boxed()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet()
                    .stream()
                    .filter(entry -> entry.getValue() >= i.length / 2)
                    .findFirst()
                    .get()
                    .getKey();
            System.out.println(mejorityElement);

        }catch (NoSuchElementException nse){
            System.out.println("Getting NoSuchElementException.");
        }
    }
    public static void convertListToMap() {
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(11, "mani", 500,"it"));
        empList.add(new Employee(22, "kumar", 1000,"it"));
        empList.add(new Employee(1, "arya", 1500,"it"));
        empList.add(new Employee(10, "sudha", 1700,"it"));

        Map<Integer, Employee> collect = empList.stream()
                .collect(Collectors.toMap(Employee::getId, Function.identity()));
        collect.forEach((k, v) -> System.out.println(k + " , " + v));
    }

    public static void reduceMethod() {
        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Optional<Integer> reduce = ints.stream().reduce((e1, e2) -> e1 * e2);
        Integer integer = reduce.get();
        System.out.println(integer);
    }

    public static void wordCount() {
        List<String> list = Arrays
                .asList("mani", "kumar", "panithi", "arya", "prasanth", "suhan", "sudha", "panithi");
        Map<String, Long> collect = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        collect.forEach((k, v) -> System.out.println(k + " : " + v));
    }

    // order echindi echinatlu undali ante groupingBy lo LinkedHashMap vadali :: edi gurtunchuko
    public static void findFirstNonRepetedChar(){
        String str = "aaWccdb";
        String val = Arrays.asList(str.split("")).stream()
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
        System.out.println(val);
    }

    public static void testInterview() {
        String key = Arrays.asList("+1A", "+2B", "+3E", "-1A+", "+3B", "+1A")
                .stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .filter(entry ->entry.getValue() >1)
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
        System.out.println(key);
    }
    public static void moveAllZerosOfIntList(List<Integer> list) {
        //move all negative numbers first
        int[] intArr1 = {-1, 2, 0, -3, 9, -8, 7};
        int[] values = Arrays.stream(intArr1).boxed()
                .collect(Collectors.partitioningBy(i -> i <= 0))
                .entrySet()
                .stream()
                .map(entry -> entry.getValue())
                .flatMap(el -> el.stream())
                .mapToInt(Integer::intValue)
                .toArray();
    }
    public static void secondHighestNumber(int[] input) {
        Integer secondValue = Arrays.stream(input)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst().get();
        System.out.println(secondValue);
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(11, "mani", 500,"it"));
        empList.add(new Employee(22, "kumar", 1000,"it"));
        empList.add(new Employee(1, "arya", 1500,"it"));
        empList.add(new Employee(11, "sudha", 1700,"it"));
        //Right way to get highest number
        Double aDouble1 = empList.stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Collections.reverseOrder())
                .skip(1)
                .findFirst()
                .get();
        System.out.println("aDouble1 ==="+aDouble1);
    }
    public static String findYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
            return "Leap year";
        return "Not Leap year";
    }

    public static void getProcessCore() {
        int[] arr = {1, 2, 3, 9, 8, 7};
        int[] ary = {2, 1, 9, 3, 4, 8};

        List<Integer> result = Stream.of(arr, ary)
                .flatMapToInt(Arrays::stream)
                .boxed()
                .collect(toList());
        int i = result.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .findFirst()
                .get()
                .getKey();
    }
    public static void findFlightSeatPosition(int seatNumber) {
        int[] original = IntStream.range(1, 100).toArray();
        int chunk = 6; // chunk size to divide
        List<int[]> lists = new ArrayList<>();
        for (int i = 0; i < original.length-1; i += chunk) {
            lists.add(Arrays.copyOfRange(original, i, Math.min(original.length, i+chunk)));
        }
        for (int i = 0; i < lists.size(); i++) {
            int[] ints = lists.get(i);
            //System.out.println(Arrays.toString(ints));
            List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
            if (list.contains(seatNumber)) {
                Integer first = list.get(0);
                Integer last = list.get(list.size() - 1);
                String seat = (first == seatNumber || last == seatNumber) ? "window seat" : "mid seat";
                System.out.println(seat);
            }
        }
    }

    public static void findLongString(){
        String s = Arrays.asList("mani", "kumar", "panithi")
                .stream()
                .reduce((w1, w2) -> w1.length() > w2.length() ? w1 : w2)
                .get();
        System.out.println(s);
    }
    public static void getData(){
        //Stream reusing by supplier
        Supplier<List<EmployeeData>> empList = () -> getEmployeeList();
        empList.get().stream().filter(emp -> emp.getGender().equalsIgnoreCase("Male"))
                .collect(Collectors.toList()).forEach(System.out::print);
        System.out.println();
        empList.get().stream().map(EmployeeData::getId).collect(Collectors.toList())
                .forEach(System.out::print);
        System.out.println();
    }


    public static void main(String[] args) throws Exception {
        System.out.println("From Main only ---->");
        System.out.println("1------>From Main only ---->");
        //testMap();
        //testLimit();
        //studentMapWithAverage();
        //System.out.println(Arrays.toString(arrayPartitioningBy3(new int[]{7, 5, 2, 1, -3, 9})));
        //System.out.println(Arrays.toString(arrayPartitioningBy3(new int[]{3,2,5,7,8,9})));
        //System.out.println(Arrays.toString(findSubArraySumZero(new int[]{7,5,2,1,-3,9})));
        //System.out.println(Arrays.toString(findSubArraySumZero(new int[]{3,2,5,7,8,9})));
        //getMergeArray();
        //checkStringPalandramOrNot("madam");

        //getHighestSalary(); //Collection.reversed() or
                             // Comparator.comparingDouble(e -> Double.valueOf(e)).reverseOrder()
        //getCommonElementsFromTwoArrays();
        //sumOfEvenAndOddNumbersInASingleLine();
        //evenNumsLeftAndOddNumsRightSaid();
        //testInterview();
        //ArrayAssAndDescArrayLogicOnly();

        //validateMobileNumber("7205854333");
        //removeNegativeValuesFromArray(new int[]{-1,2,-3,9,-8,7});
        //moveNegativeValuesAtFirstOfArray
        //clockCheck();
        //printElementFromGiven3Arrays(new int[]{1,2,3,9,8,7}, new int[]{4,1,2,10,15}, new int[]{5,1,2,4,10});
        //rotLeft(new int[]{1,2,3,9,8,7}, 2);
        //rotRight(new int[]{1,2,3,9,8,7}, 9);
        //reverseNumber(123);
        //removeElementFromArray(new int[]{1,2,3,4,5}, 3);
        //isBalanced("[[()]]}");
        //balancedSums(new int[]{1,1,1,1,2});
        //TwoStringsSplitAndAdd();
        //int i = fibonacciTest(10);
        //isPrime(11);
        //SortMapAndStroeInToLinkedHashMap();
        //findStartWithOne();
        //nonRepeatCharacter();
        //reverseAList();
        //reversStringWordByWord();
        //removeElementsFromList();
        //findMaxElementOfList();

        //sortEmpList();
        //groupingWordsByLength();
        //findMejorityElementFromGivenArray();
        //convertListToMap();
        //reduceMethod();
        //findDuplicatesFromList();
        //sortListOfEmployeeByName();
        //wordCount();
        //find_Employee_Names_Sort_With_Department_Wise();
        //mergeMap();
        //testPeek();
        //streamAreNotReUseble();
        //testStreamReuseOrNot();

        /*Ainheritance a = new Binheritance();
        a.show();//it's call Ainheritance class method only
        System.out.println(a.i);*/ // it will take Ainheritance class variable only
        //removeDuplicates(new int[]{1,2,2,3,4,4,5});
        //findNonRepeatingElement();
        //ArraySortAssAndDesc();
        //checkArraySum();
        //findLongString();
        //streamNonRepeatedElements();
        //findMissingNumInArray
        //stringPermuteAndPrint("","xyz");
        //printPermutation("xyz","");
        //findMissingNumbers();
        //System.out.println(areConsecutive());
        //findSubArraySum();
        //SubArrayWhoseSumIsGivenNumber(new int[]{12, 5, 31, 13, 21, 8}, 49);
        //splitStirngAndIntegerArrayAndSum();
        //max_Consecutive_Given_number();
        //length_Of_Longest_Substring();
    }



    public static List<EmployeeData> getEmployeeList(){
        List<EmployeeData> employeeList = new ArrayList<EmployeeData>();

        employeeList.add(new EmployeeData(111, "Jennifer", 22, "Female", "HR", 2017, 55000.0));
        employeeList.add(new EmployeeData(112, "Rohit", 35, "Male", "Sales And Marketing", 2019, 23500.0));
        employeeList.add(new EmployeeData(113, "Shubman", 29, "Male", "Infrastructure", 2019, 28000.0));
        employeeList.add(new EmployeeData(114, "Rinku", 28, "Male", "Product Development", 2020, 62500.0));
        employeeList.add(new EmployeeData(115, "Aaditi", 41, "Female", "HR", 2022, 29700.0));
        employeeList.add(new EmployeeData(116, "Mahendra", 43, "Male", "Security And Transport", 2023, 20500.0));
        employeeList.add(new EmployeeData(117, "Nitish", 35, "Male", "Account And Finance", 2019, 37000.0));
        employeeList.add(new EmployeeData(118, "Aditya", 31, "Male", "Product Development", 2019, 34500.0));
        employeeList.add(new EmployeeData(119, "Monika", 24, "Female", "Sales And Marketing", 2021, 21500.0));
        employeeList.add(new EmployeeData(120, "Aman", 38, "Male", "Security And Transport", 2021, 31000.5));
        employeeList.add(new EmployeeData(121, "Sangeeta", 27, "Female", "Infrastructure", 2021, 35000.0));
        employeeList.add(new EmployeeData(122, "Joshi", 25, "Male", "Product Development", 2020, 29000.0));
        employeeList.add(new EmployeeData(123, "Jeddy", 27, "Female", "Account And Finance", 2020, 29000.0));
        employeeList.add(new EmployeeData(124, "Niden", 24, "Male", "Sales And Marketing", 2020, 30200.5));
        employeeList.add(new EmployeeData(125, "Saig", 23, "Male", "Infrastructure", 2019, 42700.0));
        employeeList.add(new EmployeeData(126, "Saey", 26, "Female", "Product Development", 2018, 38900.0));
        employeeList.add(new EmployeeData(127, "Shreyas", 25, "Male", "Product Development", 2018, 35700.0));
        System.out.println("--data processed--");
        return employeeList;
    }

    //sub arry sum=0 : surya (hashMap)
    //Map Sorting in reverse order:: Map.Entry.<String,Integer>comparingByKey().reversed()

}
