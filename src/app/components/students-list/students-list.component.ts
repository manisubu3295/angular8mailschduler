import { Student } from './../../shared/student';
import { ApiService } from './../../shared/api.service';
import { Component, ViewChild, OnInit } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import {SelectionModel} from '@angular/cdk/collections';
import {AfterViewInit} from '@angular/core';
import {MatSort} from '@angular/material/sort';

@Component({
  selector: 'app-students-list',
  templateUrl: './students-list.component.html',
  styleUrls: ['./students-list.component.css']
})

export class StudentsListComponent  implements AfterViewInit {
  StudentData:any= [];
  dataSource: MatTableDataSource<Student>;
  @ViewChild(MatPaginator,{static:false}) paginator: MatPaginator;
  displayedColumns: string[] = ['select','_id', 'student_name', 'student_email', 'section', 'action'];
  @ViewChild(MatSort,{ static: true }) sort: MatSort;
  constructor(private studentApi: ApiService) {
      this.studentApi.GetStudents().subscribe(data => {
      this.StudentData = data;
      console.log(JSON.stringify(data)+"data")
   //   console.log(JSON.stringify(this.StudentData))
     // this.StudentData=[{"student_name":"mani","student_email":"test","section":"E","_id":1,"subjects":[],"dob":"","gender":""}]
   // this.StudentData=JSON.stringify(this.StudentData);
      console.log(this.StudentData);
      this.dataSource = new MatTableDataSource<Student>(this.StudentData);
      setTimeout(() => {
        this.dataSource.paginator = this.paginator;
      
      }, 0);
    })    
  }

  ngOnInit() { }

  deleteStudent(index: number, e){
    if(window.confirm('Are you sure')) {
      const data = this.dataSource.data;
      data.splice((this.paginator.pageIndex * this.paginator.pageSize) + index, 1);
      this.dataSource.data = data;
      this.studentApi.DeleteStudent(e._id).subscribe()
    }
  }
  
  selection = new SelectionModel<Student>(true, this.StudentData);
/** Whether the number of selected elements matches the total number of rows. */
isAllSelected() {
  const numSelected = this.selection.selected.length;
  const numRows = this.dataSource.data.length;
  return numSelected === numRows;
}

/** Selects all rows if they are not all selected; otherwise clear selection. */
masterToggle() {
  this.isAllSelected() ?
      this.selection.clear() :
      this.dataSource.data.forEach(row => this.selection.select(row));
}

/** The label for the checkbox on the passed row */
checkboxLabel(row?: Student): string {
  if (!row) {
    return `${this.isAllSelected() ? 'select' : 'deselect'} all`;
  }
  return `${this.selection.isSelected(row) ? 'deselect' : 'select'} row ${row._id + 1}`;
}

  ngAfterViewInit() {
    this.dataSource.sort = this.sort;
  }
}