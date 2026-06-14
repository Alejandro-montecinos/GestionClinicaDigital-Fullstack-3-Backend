import { Routes } from '@angular/router';
import { NotFoundComponent } from './pages/not-found-component/not-found-component';
import { PersonaComponent } from './pages/persona-component/persona-component';
import { RolComponent } from './pages/rol-component/rol-component';
import { CitaMedicaComponent } from './pages/citaMedica-component/cita-medica-component';
import { ConsultaMedicaComponent } from './pages/consultaMedica-component/consulta-medica-component';
import { InicioComponent } from './pages/inicio-component/inicio-component';
import { LoginComponent } from './pages/login-component/login-component';
import { MedicoComponent } from './pages/medico-component/medico-component';
import { SeleccionUsuarioComponent } from './pages/seleccion-usuario-component/seleccion-usuario-component';
import { InicioPacienteComponent } from './pages/inicio-paciente-component/inicio-paciente-component';

export const routes: Routes = [
  { path: '', component: InicioComponent },
  { path: 'seleccionarUsuario', component: SeleccionUsuarioComponent },
  { path: 'login', component: LoginComponent },
  { path: 'login/:tipo', component: LoginComponent },
  { path: 'persona', component: PersonaComponent },
  { path: 'medico', component: MedicoComponent },
  { path: 'consulta-medica', component: ConsultaMedicaComponent },
  { path: 'rol', component: RolComponent },
  { path: 'cita-medica', component: CitaMedicaComponent },
  { path: 'registro-paciente', component: PersonaComponent },
  { path: 'inicio-paciente', component: InicioPacienteComponent }, // 👈 Tu pantalla final
  { path: '404', component: NotFoundComponent },
  { path: '**', redirectTo: '404' } // 👈 El comodín al final de todo
];