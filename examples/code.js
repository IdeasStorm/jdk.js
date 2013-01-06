
function Student(id,name,mark) {
	this.id=id;
	this.name=name;
	this.mark=mark;
}
// Sort students list by marks 
function Sort(arr,length){
	for(var i=0;i<(length-1);i++)
		for(var j=i+1;j<length;j++)
			if(arr[i].mark < arr[j].mark)
			{
				s=arr[i];
				arr[i]=arr[j];
				arr[j]=s;
			}
}

// read students list
function readStudent(arr,length){
	var num,mark,name ;
	console.writeln("Enter Student List:");
	for (var i=0;i<length;i++)
	{
		num = i + 1 ;
		console.writeln("Student id: "+ num);
		console.writeln("Enter Student name:");
		name = console.read();
		console.writeln("Enter Student marke:");
		var mark = console.read().toNumber();
		arr[i] = new Student(num,name,mark);
	}
}

// Print students list
function Print(arr,length){
	console.writeln("Student List:");
	for (var i=0;i<size;i++)
	{
		console.writeln("id: "+arr[i].id+",\nname: "+arr[i].name+",\tmark: "+arr[i].mark);
	}
}

//Calculate avg 
function avg (arr,size){
	var sum = 0 ;
	for (var i=0;i<size;i++)
	{
		sum += arr[i].mark ;
	}
	return sum / size ;
}

//main program
var stu =[] , size = 0;
console.writeln("enter number of students :");
size = console.read().toNumber();
readStudent(stu,size);
Sort(stu,size);
Print(stu,size);
console.writeln ("avg= "+avg(stu,size));

