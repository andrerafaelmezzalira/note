INSERT INTO public.terminal(bank_code, terminal_code) VALUES(104,1);

INSERT INTO public.note(value) VALUES(10);
INSERT INTO public.note(value) VALUES(20);
INSERT INTO public.note(value) VALUES(50);
INSERT INTO public.note(value) VALUES(100);

INSERT INTO public.stock(quantity, note_id, terminal_id) VALUES(100, 1, 1);
INSERT INTO public.stock(quantity, note_id, terminal_id) VALUES(100, 2, 1);
INSERT INTO public.stock(quantity, note_id, terminal_id) VALUES(100, 3, 1);
INSERT INTO public.stock(quantity, note_id, terminal_id) VALUES(100, 4, 1);

