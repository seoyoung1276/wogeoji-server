-- Insert sample groups
INSERT INTO community_group (group_id, name, description, headcount_limit) VALUES
                                                                               (1, 'Group 1', 'Sample group 1', 10),
                                                                               (2, 'Group 2', 'Sample group 2', 5);

-- Insert sample members
INSERT INTO member (member_id, name, id, pw, email) VALUES
                                                        (1, 'John', 'john123', 'password123', 'john@example.com'),
                                                        (2, 'Alice', 'alice456', 'password456', 'alice@example.com');

-- Associate members with groups
INSERT INTO user_group (user_id, group_id) VALUES
                                               (1, 1), -- John is in Group 1
                                               (1, 2), -- John is also in Group 2
                                               (2, 1); -- Alice is in Group 1