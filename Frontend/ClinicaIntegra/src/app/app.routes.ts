import { Routes } from '@angular/router';

import { NotFoundComponent } from './pages/not-found-component/not-found-component';
import { PersonaComponent } from './pages/persona-component/persona-component';
import { TratamientoComponent } from './pages/tratamiento-component/tratamiento-component';
import { RolComponent } from './pages/rol-component/rol-component';
import { CitaMedicaComponent } from './pages/citaMedica-component/cita-medica-component';
import { ConsultaMedicaComponent } from './pages/consultaMedica-component/consulta-medica-component';
import { InicioComponent } from './pages/inicio-component/inicio-component';
import { LoginComponent } from './pages/login-component/login-component';
import { DashboardPersonaComponent } from './pages/dashboard-persona-component/dashboard-persona-component';
import { MedicoComponent } from './pages/medico-component/medico-component';

export const routes: Routes = [

     {
    path: '',
    component: InicioComponent,
  },
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'dashboard-persona',
    component: DashboardPersonaComponent,
  },
  {
    path: 'Persona',
    component: PersonaComponent,
  },
  {
    path: 'Medico',
    component: MedicoComponent,
  },
  {
    path: 'ConsultaMedica',
    component: ConsultaMedicaComponent,
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
    path: '404',
    component: NotFoundComponent,
  },
  {
    path: '**',
    redirectTo: '404'
  }

];