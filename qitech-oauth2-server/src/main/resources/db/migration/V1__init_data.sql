insert into oauth_client_details(client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, access_token_validity, refresh_token_validity)
values ('web','resource','$2a$10$pfjPTjSgTdJspAznNIB2d.ssmvg.v7a4R8sxrvO1EwQrJuBA6pbLa','all','authorization_code,password,refresh_token','http://example.com',6000,6000);
insert into oauth_client_details(client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, access_token_validity, refresh_token_validity)
values ('client','resource','$2a$10$lPmK1EESGEBWB.MCK7LmcOH4LsQBXw0FjTQL5emKv.ntJ0TQnyYjS','all','authorization_code,password,refresh_token','http://example.com',6000,6000);