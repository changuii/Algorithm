
SELECT b.id AS ID, b.genotype AS GENOTYPE, a.genotype AS PARENT_GENOTYPE
FROM ECOLI_DATA a, ECOLI_DATA b
WHERE a.id = b.parent_id
AND (a.genotype & b.genotype) = a.genotype