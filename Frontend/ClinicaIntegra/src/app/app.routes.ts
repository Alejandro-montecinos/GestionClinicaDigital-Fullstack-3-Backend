import { Routes } from '@angular/router';

import { NotFoundComponent } from './pages/not-found-component/not-found-component';
import { PersonaComponent } from './pages/persona-component/persona-component';
import { TratamientoComponent } from './pages/tratamiento-component/tratamiento-component';
import { RolComponent } from './pages/rol-component/rol-component';
import { CitaMedicaComponent } from './pages/citaMedica-component/cita-medica-component';
import { ConsultaMedicaComponent } from './pages/consultaMedica-component/consulta-medica-component';

export const routes: Routes = [

    {
    path: '',
    component: PersonaComponent,
    },
    {
    path: 'Tratamiento',
    component: TratamientoComponent,
    },
    {
    path: 'Rol',
    component: RolComponent,
    },
    {
    path: 'CitaMedica',
    component: CitaMedicaComponent,
    },
    {
    path: 'ConsultaMedica',
    component: ConsultaMedicaComponent,
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
