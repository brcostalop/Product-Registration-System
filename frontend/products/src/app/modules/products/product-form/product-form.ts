import {Component, OnInit} from '@angular/core';
import {Product} from '../product.model';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {Service} from '../../service/service';
import {ActivatedRoute, Router} from '@angular/router';
import {MatList, MatListItem} from '@angular/material/list';
import {MatFormField, MatInput, MatLabel, MatPrefix, MatSuffix} from '@angular/material/input';
import {MatButton} from '@angular/material/button';

@Component({
  selector: 'app-product-form',
  imports: [
    ReactiveFormsModule,
    MatFormField,
    MatInput,
    MatLabel,
    MatFormField,
    MatButton,
    MatPrefix,
    MatSuffix
  ],
  templateUrl: './product-form.html',
  styleUrl: './product-form.scss'
})
export class ProductForm implements OnInit{
  form!: FormGroup;
  id?: number;

  constructor(private fb: FormBuilder, private productService: Service,
              private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.form = this.fb.group({
      name: ['', Validators.required],
      category: ['', Validators.required],
      price: [0, Validators.required],
      description: ['']
    });

    this.id = this.route.snapshot.params['id'];
    if (this.id) {
      this.productService.searchById(this.id).subscribe((product) => {
        this.form.patchValue(product);
      })
    }
  }

  save(): void {
    if (this.form.invalid)
      return;

    const action = this.id
      ? this.productService.edit(this.id, this.form.value)
      : this.productService.save(this.form.value);

    action.subscribe(() => this.router.navigate(['/produtos']));
  }

  return(): void {
    this.router.navigate(['/produtos']);
  }

}
