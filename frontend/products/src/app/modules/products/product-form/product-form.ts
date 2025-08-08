import {Component, OnInit} from '@angular/core';
import {Product} from '../product.model';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {Service} from '../../service/service';

@Component({
  selector: 'app-product-form',
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './product-form.html',
  styleUrl: './product-form.scss'
})
export class ProductForm implements OnInit{
  form!: FormGroup;

  constructor(private fb: FormBuilder, private service: Service) {
  }

  ngOnInit() {
    this.form = this.fb.group({
      name: ['', Validators.required],
      category: ['', Validators.required],
      price: [0, Validators.required],
      description: ['']
    });

  }

  save(): void {
    debugger
    if (this.form.invalid)
      return;

    this.service.save(this.form.value).subscribe({
      next: (data) => {
        // this.form.reset();
      },
      error: (err) => {}
    })
  }

}
