import { Routes } from '@angular/router';
import { NotFoundComponent } from './pages/not-found-component/not-found-component';
import { PersonaComponent } from './pages/persona-component/persona-component';


export const routes: Routes = [

    {
    path: '',
    component: PersonaComponent,
    },
    {
    path: '404',
    component: NotFoundComponent,
    },
    {
    path: '**',
    redirectTo:"404"
    }


];
