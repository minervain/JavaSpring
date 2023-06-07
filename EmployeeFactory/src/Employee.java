public class Employee {
    String name;
    int salary;
    int workHours;
    int hireYear;
    Employee(String name, int salary, int workHours,   int hireYear){

        this.name=name;
        this.salary=salary;
        this.workHours=workHours;
        this.hireYear=hireYear;
    }

   public double tax(){
        if(salary<1000){
          return   this.salary=salary;
        }
        else {
           return this.salary=salary+(salary*3)/100;
        }
   }
    public int bonus(){
        if (workHours>40){
           return this.salary=this.salary+(workHours-40)*30;
        }
        else {
            return 0;
        }

    }

    public int raiseSalary(){
        if(hireYear<10){
         return  this.salary=this.salary+(this.salary*5)/100;

        }
        else if(hireYear>9&&hireYear<20){
           return this.salary=this.salary+(this.salary*10)/100;
        }
        else {
           return this.salary=this.salary+(this.salary*15)/100;
        }
    }

    public String toStrng(){
      return   "Name: " + name +
              "\nSalary: " + salary +
              "\nWork Hours: " + workHours +
              "\nHire Year: " + hireYear;




    }
}

