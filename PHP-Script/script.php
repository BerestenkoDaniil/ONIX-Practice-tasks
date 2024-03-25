<?php

// Function to get current date based on custom format
function getCurrentDate($format) {
    return date($format);
}

// Function to validate input
function validateInput($title, $author, $categories) {
    if (empty($title) || empty($author) || empty($categories)) {
        echo "Error: Title, author, and category cannot be empty.\n";
        return false;
    }
    return true;
}

// Prompt user for input
echo "Enter the blog post title: ";
$title = trim(fgets(STDIN));

echo "Enter the author's name: ";
$author = trim(fgets(STDIN));

echo "Enter the category/categories (separated by commas if multiple): ";
$categoriesInput = trim(fgets(STDIN));

// Validate input
if (!validateInput($title, $author, $categoriesInput)) {
    exit(1);
}

// Parse categories
$categories = explode(",", $categoriesInput);
$categories = array_map('trim', $categories);

// Prompt user for optional custom date format
echo "Enter the custom date format (leave blank for default 'Y-m-d'): ";
$dateFormat = trim(fgets(STDIN));
if (empty($dateFormat)) {
    $dateFormat = 'Y-m-d';
}

// Generate filename
$timestamp = date("YmdHis");
$filename = strtolower(str_replace(' ', '-', $title)) . "-" . strtolower(str_replace(' ', '-', $author)) . "-" . $timestamp . ".md";

// Get current date
$date = getCurrentDate($dateFormat);

// Generate metadata string for categories
$categoriesString = '';
foreach ($categories as $category) {
    $categoriesString .= "- $category\n";
}

// Generate markdown content
$content = <<<MARKDOWN
---
title: "$title"
author: "$author"
category:
$categoriesString
date: "$date"
---

Write your blog post content here...

MARKDOWN;

// Determine output directory
$outputDir = isset($argv[1]) ? rtrim($argv[1], '/') . '/' : './';

// Write content to file
$file = fopen($outputDir . $filename, "w") or die("Error: Unable to open file.");
fwrite($file, $content);
fclose($file);

// Output file path to user
echo "Blog post template generated successfully. File saved to: " . $outputDir . $filename . "\n";
?>
