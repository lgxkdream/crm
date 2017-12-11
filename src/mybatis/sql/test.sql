select sm.id as id
,sm.sort as sort
,sm.name as name
,sm.html as html
,sm.parnet_id as parent_id
,sm.type  as type
from sys_menu sm, sys_role sr, sys_role_menu srm, sys_user su
where sm.id=srm.menu_id 
and sr.id=srm.role_id
and su.role_id=sr.id
and su.id=