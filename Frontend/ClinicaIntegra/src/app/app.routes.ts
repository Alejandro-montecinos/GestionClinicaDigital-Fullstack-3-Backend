import { Routes } from '@angular/router';
import { NotFoundComponent } from './pages/not-found-component/not-found-component';
import { PersonaComponent } from './pages/persona-component/persona-component';
import { RolComponent } from './pages/rol-component/rol-component';
import { ConsultaMedicaComponent } from './pages/consultaMedica-component/consulta-medica-component';
import { InicioComponent } from './pages/inicio-component/inicio-component';
import { LoginComponent } from './pages/login-component/login-component';
import { MedicoComponent } from './pages/medico-component/medico-component';
import { SeleccionUsuarioComponent } from './pages/seleccion-usuario-component/seleccion-usuario-component';
import { InicioPacienteComponent } from './pages/inicio-paciente-component/inicio-paciente-component';
import { CitaMedicaComponent } from './pages/cita-medica-component/cita-medica-component';
import { InicioMedicoComponent } from './pages/inicio-medico-component/inicio-medico-component';

export const routes: Routes = [
  { path: '', component: InicioComponent, pathMatch: 'full' },
  { path: 'seleccionarUsuario', component: SeleccionUsuarioComponent },
  { path: 'login', component: LoginComponent },
  { path: 'login/:tipo', component: LoginComponent },
  { path: 'persona', component: PersonaComponent },
  { path: 'medico', component: MedicoComponent },
  
  // CORREGIDO: Ahora el path se llama 'inicio-medico' para que el Login lo encuentre
  { path: 'inicio-medico', component: InicioMedicoComponent },
  
  { path: 'rol', component: RolComponent },
  { path: 'registro-paciente', component: PersonaComponent },
  { path: 'inicio-paciente', component: InicioPacienteComponent },
  { path: 'cita-medica', component: CitaMedicaComponent },
  { path: '404', component: NotFoundComponent },
  
  { path: '**', redirectTo: '404' }
];