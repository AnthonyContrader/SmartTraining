import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminLayoutComponent } from '../layout/admin-layout/admin-layout.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UsersComponent } from './users/users.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';
import { AuthGuard } from '../../guard/auth/auth.guard';
import { StudentComponent } from './student/student.component';
import { GruppoComponent } from './gruppo/gruppo.component';
import { TrainingComponent } from './training/training.component';
import { ContentComponent } from './content/content.component';


/**
 * Modulo di routing dell'admin. Qui ci sono i percorsi che un admin può seguire:
 * appena fa il login viene caricato nel <router-outlet> di app-component il layout e nel 
 * <router-outlet> del layout (come percorsi "children") vengono visualizzati gli altri 
 * (qui sotto sono indentati). Si osservi il Guard "canActivate: [AuthGuard]" che protegge le routes
 * del'ADMIN dagli altri utenti.
 * 
 * @author Vittorio Valent
 * 
 * @see AdminLayoutComponent
 * @see AuthGuard
 * @see layout
 */
const routes: Routes = [
  {
    path: 'admin-dashboard', component: AdminLayoutComponent, children: [
      { path: '', component: AdminDashboardComponent },
      { path: 'users', component: UsersComponent },
      { path: 'student', component: StudentComponent},
      { path: 'gruppo', component: GruppoComponent},
      { path: 'training', component: TrainingComponent},
      { path: 'content', component: ContentComponent},

      { path: 'work-in-progress', component: WorkInProgressComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }