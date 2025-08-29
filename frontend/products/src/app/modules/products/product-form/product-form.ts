import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {Service} from '../../service/service';
import {ActivatedRoute, Router} from '@angular/router';
import {
  MatCardModule,
} from '@angular/material/card';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';

@Component({
  selector: 'app-product-form',
  imports: [
    ReactiveFormsModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
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
      price: ['', Validators.required],
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
