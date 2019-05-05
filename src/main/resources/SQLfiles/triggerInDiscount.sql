BEGIN
IF NEW.count_discount >= 5 THEN
SET NEW.discount_percentage = 200;
END IF;
END